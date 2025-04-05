# Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy Maven configuration files
COPY pom.xml .
COPY settings.xml /root/.m2/
# Download dependencies without building the app
RUN mvn dependency:go-offline

# Copy the source code
COPY src /app/src

# Package the application (skip tests for faster builds)
RUN mvn clean package -DskipTests

# Run stage using Corretto 21
FROM amazoncorretto:21-alpine
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (default for Spring Boot)
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
