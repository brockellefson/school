
#include <string.h>
#include <Arduino.h>
#include <SPI.h>
#include <Wire.h>
#include <Adafruit_MotorShield.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

#include "BluefruitConfig.h"

Adafruit_MotorShield AFMS = Adafruit_MotorShield(); //create shield
//Create Motors
Adafruit_DCMotor *RMotor = AFMS.getMotor(3);
Adafruit_DCMotor *LMotor = AFMS.getMotor(4);

int state = 0;


void setup(void)
{

  Serial.begin(9600);
  Serial.println(F("Jaquel is online"));
  Serial.println(F("-----------------------------------------"));
  Serial.println("Requesting Bluefruit info:");

  
   //Start Motors
  AFMS.begin();  // create with the default frequency 1.6KHz
  Serial.println(F("----------------------------------------"));
  LMotor->setSpeed(150);
  LMotor->run(FORWARD);
  LMotor->run(RELEASE);
  Serial.println(F("Motor 1 Running"));

  RMotor->setSpeed(150);
  RMotor->run(FORWARD);
  RMotor->run(RELEASE);
  Serial.println(F("Motor 2 Running"));
  Serial.println(F("----------------------------------------"));

  Serial.println(F("----------------------------------------"));

}

void loop(void)
{
 if(Serial.available() > 0){ // Checks whether data is comming from the serial port
  state = Serial.read(); // Reads the data from the serial port
  Serial.println(state);
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
  else{
  RMotor->run(RELEASE);
  LMotor->run(RELEASE);  
  }
}
