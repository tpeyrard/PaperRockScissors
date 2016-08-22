# PaperRockScissors

## Requirements
1. Java 8
2. Maven 3

## Build and tests
`mvn clean package`

## Run
`java -jar target/prs-1.0-SNAPSHOT.jar <NUMBER_OF_PARTIES>`

## Docker
```
docker build -t prs .

docker run -i prs
```

Don't forget `-i` option in order to use the SDTIN.
