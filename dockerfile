FROM java:8u102-jdk

WORKDIR /home

RUN apt-get update \
  && apt-get -y install maven \
  && git clone https://github.com/tpeyrard/PaperRockScissors.git \
  && cd  PaperRockScissors \
  && mvn clean package

CMD java -jar /home/PaperRockScissors/target/prs-1.0-SNAPSHOT.jar 3