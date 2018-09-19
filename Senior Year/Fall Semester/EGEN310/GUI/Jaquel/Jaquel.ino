#include <string.h>
#include <Arduino.h>
#include <SPI.h>
#if not defined (_VARIANT_ARDUINO_DUE_X_)
  #include <SoftwareSerial.h>
#endif

#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

#include "BluefruitConfig.h"

#include <Wire.h>
#include <Adafruit_MotorShield.h>

    #define FACTORYRESET_ENABLE         1
    #define MINIMUM_FIRMWARE_VERSION    "0.6.6"
    #define MODE_LED_BEHAVIOUR          "MODE"

Adafruit_MotorShield AFMS = Adafruit_MotorShield(); 

String BROADCAST_NAME = "EGEN310 G.6 Jaquel";
String BROADCAST_CMD = String("AT+GAPDEVNAME=" + BROADCAST_NAME);
Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

//Create Motors
Adafruit_DCMotor *RMotor = AFMS.getMotor(3);
Adafruit_DCMotor *LMotor = AFMS.getMotor(4);

int state = 0;

void setup(void) {
  Serial.begin(115200); //or 9600
  Serial.println(F("Jaquel is online"));
  Serial.println(F("-----------------------------------------"));
  
  
  /* Initialise the module */
  Serial.print(F("Initialising the Bluefruit LE module: "));

  Serial.println( F("OK!") );

/* Disable command echo from Bluefruit */
  ble.echo(false);

  Serial.println("Requesting Bluefruit info:");
  /* Print Bluefruit information */
  ble.info();

  Serial.println(F("Please use Adafruit Bluefruit LE app to connect in Controller mode"));
  Serial.println(F("Then activate/use the sensors, color picker, game controller, etc!"));
  Serial.println();

  ble.verbose(false);  // debug info is a little annoying after this point!

  /* Wait for connection */
  while (! ble.isConnected()) {
      delay(500);
  }

  Serial.println(F("******************************"));

  // LED Activity command is only supported from 0.6.6
  if ( ble.isVersionAtLeast(MINIMUM_FIRMWARE_VERSION) )
  {
    // Change Mode LED Activity
    Serial.println(F("Change LED activity to " MODE_LED_BEHAVIOUR));
    ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
  }

  // Set Bluefruit to DATA mode
  Serial.println( F("Switching to DATA mode!") );
  ble.setMode(BLUEFRUIT_MODE_DATA);

  Serial.println(F("******************************"));



  AFMS.begin();  // create with the default frequency 1.6KHz
  
  LMotor->setSpeed(150);
  LMotor->run(FORWARD);
  LMotor->run(RELEASE);


  RMotor->setSpeed(150);
  RMotor->run(FORWARD);
  RMotor->run(RELEASE);
}

void loop(void) {
if(Serial.available() > 0){ // Checks whether data is comming from the serial port
    state = Serial.read(); // Reads the data from the serial port
 }
 if (state == '0') {
  RMotor->run(RELEASE);
  LMotor->run(RELEASE);
  Serial.println("Jaquel has stopped"); // Send back, to the phone
  state = 0;
 }
 else if (state == '1') {
  RMotor->run(FORWARD);
  LMotor->run(FORWARD);
  Serial.println("Jaquel is running forward");
 } 
 else if (state == '2') {
  RMotor->run(FORWARD);
  LMotor->run(BACKWARD);
  Serial.println("Jaquel is turning left");
 }
  else if (state == '3') {
  LMotor->run(FORWARD);
  RMotor->run(BACKWARD);
  Serial.println("Jaquel is turning right");
  }
  else if (state == '4') {
  RMotor->run(BACKWARD);
  LMotor->run(BACKWARD);
  Serial.println("Jaquel is going backwards");
  }
}

