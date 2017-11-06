
#include <string.h>
#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_MotorShield.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

#include "BluefruitConfig.h"

#if SOFTWARE_SERIAL_AVAILABLE
  #include <SoftwareSerial.h>
#endif

    #define FACTORYRESET_ENABLE         1
    #define MINIMUM_FIRMWARE_VERSION    "0.6.6"
    #define MODE_LED_BEHAVIOUR          "MODE"

Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);


Adafruit_MotorShield AFMS = Adafruit_MotorShield(); //create shield
//Create Motors
Adafruit_DCMotor *RMotor = AFMS.getMotor(3);
Adafruit_DCMotor *LMotor = AFMS.getMotor(4);

int state = 0;


// A small helper
void error(const __FlashStringHelper*err) {
  Serial.println(err);
  while (1);
}

// function prototypes over in packetparser.cpp
uint8_t readPacket(Adafruit_BLE *ble, uint16_t timeout);
float parsefloat(uint8_t *buffer);
void printHex(const uint8_t * data, const uint32_t numBytes);

// the packet buffer
extern uint8_t packetbuffer[];


void setup(void)
{
  while (!Serial);  // required for Flora & Micro
  delay(500);

  Serial.begin(115200);
  Serial.println(F("Jaquel is online"));
  Serial.println(F("-----------------------------------------"));

  /* Initialise the module */
  Serial.print(F("Initialising the Bluefruit LE module: "));

  if ( !ble.begin(VERBOSE_MODE) )
  {
    error(F("Couldn't find Bluefruit, make sure it's in CoMmanD mode & check wiring?"));
  }
  Serial.println( F("OK!") );

  if ( FACTORYRESET_ENABLE )
  {
    /* Perform a factory reset to make sure everything is in a known state */
    Serial.println(F("Performing a factory reset: "));
    if ( ! ble.factoryReset() ){
      error(F("Couldn't factory reset"));
    }
  }


  /* Disable command echo from Bluefruit */
  ble.echo(false);

  Serial.println("Requesting Bluefruit info:");
  /* Print Bluefruit information */
  ble.info();
  
   //Start Motors
  AFMS.begin();  // create with the default frequency 1.6KHz
  Serial.println(F("******************************"));
  LMotor->setSpeed(150);
  LMotor->run(FORWARD);
  LMotor->run(RELEASE);
  Serial.println(F("Motor 1 Running"));

  RMotor->setSpeed(150);
  RMotor->run(FORWARD);
  RMotor->run(RELEASE);
  Serial.println(F("Motor 2 Running"));
  Serial.println(F("******************************"));
  
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
  Serial.println( F("Ready to recieve data") );
  ble.setMode(BLUEFRUIT_MODE_DATA);

  Serial.println(F("******************************"));

}

void loop(void)
{
  if(ble.available() > 0){ // Checks whether data is comming from the serial port
    state = ble.read(); // Reads the data from the serial port
 }
 if (state == '0') {
  RMotor->run(RELEASE);
  LMotor->run(RELEASE);
  Serial.println((char)state);
  Serial.println("Jaquel has stopped"); // Send back, to the phone
  state = 0;
 }
 else if (state == '1') {
  RMotor->run(FORWARD);
  LMotor->run(FORWARD);
  Serial.println((char)state);
  Serial.println("Jaquel is running forward");
 } 
 else if (state == '2') {
  RMotor->run(FORWARD);
  LMotor->run(BACKWARD);
  Serial.println((char)state);  
  Serial.println("Jaquel is turning left");
 }
  else if (state == '3') {
  LMotor->run(FORWARD);
  RMotor->run(BACKWARD);
  Serial.println((char)state);
  Serial.println("Jaquel is turning right");
  }
  else if (state == '4') {
  RMotor->run(BACKWARD);
  LMotor->run(BACKWARD);
  Serial.println((char)state);  
  Serial.println("Jaquel is going backwards");
  }
}
