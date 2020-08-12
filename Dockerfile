FROM openjdk:14
ADD target/daisyapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]