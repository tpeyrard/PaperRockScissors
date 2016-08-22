# PaperRockScissors

## Requirements
1. Java 8
2. Maven 3

## Build and tests
`mvn clean package`

## Run
`java -jar target/prs-1.0-SNAPSHOT.jar <NUMBER_OF_PARTIES>`

## Docker
There is a docker branch containing the docker file. It does not work very well because NPE on the inputstream. I don't know yet whether it's related to Docker or not.
