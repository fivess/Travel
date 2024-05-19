FROM openjdk:17-alpine

WORKDIR /app

COPY /build/libs/travel_scheduler-0.0.1-SNAPSHOT.jar /app


CMD ["java","-Dspring.profiles.active=prod", "-jar", "travel_scheduler-0.0.1-SNAPSHOT.jar"]
