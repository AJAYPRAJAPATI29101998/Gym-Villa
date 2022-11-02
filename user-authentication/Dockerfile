FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-authentication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/user-authentication-0.0.1-SNAPSHOT.jar"]