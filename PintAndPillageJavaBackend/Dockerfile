FROM maven:3.9.6-amazoncorretto-17 AS builder #Image with maven for building .jar
 WORKDIR /app
 COPY src ./src
 COPY pom.xml ./pom.xml
 RUN ["mvn", "clean", "package", "-DskipTests"]
 FROM openjdk:17-jdk-slim #Smaller image for running application
 WORKDIR /app
 COPY --from=builder /app/target/pintandpillage-0.0.1-SNAPSHOT.jar backend.jar
 ENTRYPOINT ["java","-jar","./backend.jar"]