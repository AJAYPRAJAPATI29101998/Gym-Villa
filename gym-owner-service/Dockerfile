FROM openjdk:11
ADD ./target/gym-owner-service-0.0.1-SNAPSHOT.jar /usr/src/gym-owner-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar","/gym-owner-service-0.0.1-SNAPSHOT.jar"]