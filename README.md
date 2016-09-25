# EffiFly
A scalable IoT based solution providing real-time monitoring of overhead compartment occupancy to both passengers and flight attendants via a front-end based on an Android application.
## Inspiration
During the boarding process one of the pain points for both passengers and flight attendants is the management of overhead compartment space. There is a need for an automated system which can provide real-time monitoring of the overhead compartment space occupancy. In this way, passengers don't need to manually scan through all the overhead compartments, which would otherwise have blocked the passengers coming in behind them. Flight attendants can also know exactly when to start checking-in carry-on luggage.
## What it does
A scalable IoT based solution providing real-time monitoring of overhead compartment occupancy to both passengers and flight attendants via a front-end based on an Android application.
## How we built it
We deployed 2 low-cost load sensors per overhead compartment which detect luggage placed on them and signal this information to the data collection module (Intel Edison board programmed in Arduino environment). The data collection module reports this information to a server which uploads it to the Firebase database. The application running on the smartphone of the passenger or flight attendant acts as a client, receiving data from the database and displaying a real-time visualization of the available space in all the overhead compartments.
## Challenges we ran into
We were relatively new to IoT and Arduino development and we had to learn quickly about integrating multiple technologies into one single product in limited time given a limited variety of available hardware.
## Accomplishments that we're proud of
Successful development of a sensor network (data collection module + a number of low cost sensors deployed throughout all overhead compartments)
Successful development of a main server which takes data from the data collection module and uploads it to the Firebase database over the internet.
Successful development of a client front-end android visualizing real-time availability space in all the overhead compartments of the plane.
## What we learned
Embedded Software development for scalable low power and low cost sensor networks using Intel Edison board with Arduino framework
Usage of online database (Firebase) to extend the network to the scope of IoT
Integration of android app with the whole framework to enable a user friendly experience and to add value to the product
## What's next for EffiFly
Integration with Airline Apps in order to consolidate this solution with all other online services which Delta already provides.
