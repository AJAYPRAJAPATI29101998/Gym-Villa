FROM openjdk:11
ADD ./target/feedback-review-service-0.0.1-SNAPSHOT.jar /usr/src/feedback-review-service-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "feedback-review-service-0.0.1-SNAPSHOT.jar"]