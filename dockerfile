FROM java:8

WORKDIR /home

RUN apt-get update \
  && apt-get -y install maven \
  && git clone https://github.com/tpeyrard/PaperRockScissors.git \
  && update-java-alternatives -s java-1.8.0-openjdk-amd64 \
  && cd  PaperRockScissors \
  && mvn clean package

CMD java -jar /home/PaperRockScissors/target/prs-1.0-SNAPSHOT.jar 3

