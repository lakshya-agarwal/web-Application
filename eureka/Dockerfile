FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Use an official OpenJDK image as the base image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/Eureka-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "Eureka-0.0.1-SNAPSHOT.jar"]

