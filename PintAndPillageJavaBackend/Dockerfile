 #Image with maven for building jar
FROM maven:3.9.6-amazoncorretto-17 AS builder
 WORKDIR /app
 COPY src ./src
 COPY pom.xml ./pom.xml
 COPY application.properties ./application.properties
 RUN ["mvn", "clean", "package", "-DskipTests"]
 #Smaller image for running application
 FROM openjdk:17-jdk-slim
 WORKDIR /app
 COPY --from=builder /app/target/pintandpillage-0.0.1-SNAPSHOT.jar backend.jar
 COPY --from=builder /app/application.properties application.properties
 ENTRYPOINT ["java","-jar","./backend.jar"]