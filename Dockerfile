# Step 1: Build stage112233
FROM maven:3.9.9-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the Maven project
RUN mvn clean package -P alzza -DskipTests

# Step 2: Runtime stage
FROM openjdk:8-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/your-app-name.jar /app/your-app-name.jar

# Run the JAR file
CMD ["java", "-jar", "/app/your-app-name.jar"]
