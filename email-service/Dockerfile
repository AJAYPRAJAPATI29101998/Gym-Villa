FROM openjdk:11
ADD ./target/email-service-0.0.1-SNAPSHOT.jar usr/src/email-service-0.0.1-SNAPSHOT.jar
#ARG JAR_FILE=target/email-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
#COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/email-service-0.0.1-SNAPSHOT.jar"]
