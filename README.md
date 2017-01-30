# Berlin clock problem

Basic example with one constructor taking three parameters.

The method toString prints the colour and status (ON/OFF) of each row of the clock


## Output Example

For a time 21:45:13, the output will be:

(YELLOW OFF)
(RED ON)(RED ON)(RED ON)(RED ON)
(RED ON)(RED OFF)(RED OFF)(RED OFF)
(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW ON)(YELLOW ON)(RED ON)(YELLOW OFF)(YELLOW OFF)
(YELLOW OFF)(YELLOW OFF)(YELLOW OFF)(YELLOW OFF)

## Notes

* We assume the parameters for the constructor are valid.

## Execute

mvn package

java -classpath target/berlin.clock-1.0-SNAPSHOT.jar rafael.ordonez.berlinclock.MainBerlinClock 21 23 3


