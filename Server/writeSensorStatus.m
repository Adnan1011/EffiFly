clc;
clear;

nSensors = 6;
nSensorsPerCabin = 2;
nCabins = nSensors / nSensorsPerCabin;
baudRate = 115200;
FileName = 'sensorStatus.txt';

serialPort = serial('/dev/cu.usbmodem1413', 'BaudRate', baudRate, 'Timeout', inf);
fopen(serialPort);

fileID = [];

% Get updated Sensor Status from sensor board and
% write results to a file
while(1)
   for i = 1 : nCabins
       msg = fscanf(serialPort);
       if(i == 1)
           fileID = fopen(FileName, 'wt');
       end
       fprintf(fileID, '%s', msg);       
   end
   fclose(fileID);
end
