FROM openjdk:8-jdk-alpine

# Set the working directory to /app
WORKDIR /Users/Ram/Development/KeyPR/HR_Reservation/hr_reservation

VOLUME /Users/Ram/Development/KeyPR/HR_Reservation/hr_reservation
ARG JAR_FILE
ADD //Users/Ram/Development/KeyPR/HR_Reservation/hr_reservation/target/hr_reservation-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]