#!/bin/sh

echo "Starting the 'adder' project "
cd adder
./mvnw quarkus:dev &
ADDER_PID=$!
sleep 5
cd ..

echo "Starting the 'multiplier' project "
cd multiplier
./mvnw quarkus:dev &
MULTIPLIER_PID=$!
sleep 5
cd ..

echo
read -p "Press enter to Terminate"
echo 
kill $ADDER_PID $MULTIPLIER_PID
sleep 2
echo "All services terminated"
echo
