# === Stage 1: Build with Maven ===
FROM maven:3.9.6-eclipse-temurin-11 AS builder

WORKDIR /app
COPY . /app

# Build the application
RUN mvn clean package -DskipTests

# === Stage 2: Run with minimal JRE ===
FROM openjdk:11-jre-slim

WORKDIR /app

# Copy only the built JAR from the builder stage
COPY --from=builder /app/target/post-pilot-service-1.0-SNAPSHOT.jar post-pilot-service-1.0-SNAPSHOT.jar

EXPOSE 9999

ENTRYPOINT ["java", "-jar", "post-pilot-service-1.0-SNAPSHOT.jar"]