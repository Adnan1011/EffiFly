// Demo Sensor board code for Delta Project

#include<string>
#include<sstream>

#define PIN_START 2
#define PIN_END 7
#define NUM_SENSORS 6
#define SENSORS_PER_CABIN 2
#define NUM_CABINS (NUM_SENSORS / SENSORS_PER_CABIN)
#define BAUDRATE 115200

#define GET_PIN_NUMBER(num_) (num_ + 2)
#define GET_FIRST_SPOT(cabin_num_) (cabin_num_ << 1)
#define GET_SECOND_SPOT(cabin_num_) ((cabin_num_ << 1) + 1)

using namespace std;

bool currSensorStatus[NUM_SENSORS];
bool prevSensorStatus[NUM_SENSORS];

void setup()
{    
  int i;
  // Configure pins for touch sensor input signals
  for(i = PIN_START; i <= PIN_END; i++)
  {
    pinMode(i, INPUT); 
  }
  // initialize previous sensor status array
  for(i = 0; i < NUM_SENSORS; i++)
  {
    prevSensorStatus[i] = LOW;
  }
  // initialize current sensor status array
  for(i = 0; i < NUM_SENSORS; i++)
  {
    currSensorStatus[i] = LOW;
  }
  // Initialize serial port
  Serial.begin(BAUDRATE);     
}

void readSensorStatus()
{
  int i;  
  for(i = 0; i < NUM_SENSORS; i++)
  {
    currSensorStatus[i] = digitalRead(GET_PIN_NUMBER(i));    
  }
}

bool hasSensorStatusChanged()
{
  int i;
  for(i = 0; i < NUM_SENSORS; i++)
  {
    if(prevSensorStatus[i] != currSensorStatus[i])
    {
      return true;
    }
  }
  return false;
}

void updatePrevSensorStatus()
{
  int i;
  for(i = 0; i < NUM_SENSORS; i++)
  {
    prevSensorStatus[i] = currSensorStatus[i];
  }
}

void publishSensorStatus()
{
   int i;
   stringstream outStream;
   for(i = 0; i < NUM_CABINS; i++)
   {
     outStream << "\"C0" << i + 1 << "\",\"";
     outStream << currSensorStatus[GET_FIRST_SPOT(i)] << ":" << currSensorStatus[GET_SECOND_SPOT(i)];
     outStream << "\"" << endl;
   }
   Serial.write(outStream.str().c_str());
}

void loop()
{
  // Read status of all sensors
  readSensorStatus();
  // if sensors' status changes then publish the new status
  if(hasSensorStatusChanged())
  {
    // update previous sensor state
    updatePrevSensorStatus();
    // Send the status of all sensors via serial
    publishSensorStatus(); 
  }  
  // polling delay
  delay(10);
}
