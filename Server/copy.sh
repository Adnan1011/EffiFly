#!/bin/sh

SendToFB() {
curl -X PATCH -d '{'$col1':'$col2'}'   'https://cabin-49a08.firebaseio.com/Cabin.json'
}

ReadFile() {
while IFS=, read col1 col2
do
    echo "$col1:$col2"	
    SendToFB $col1 $col2
done < sensorStatus.txt
}

ReadFile
