# Step 1: Build stage - Maven 3.9.0 + OpenJDK 17
FROM maven:3.9.0-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy Maven project files (pom.xml first to leverage Docker cache)
COPY pom.xml .  
COPY src ./src  # Copy the source code

# Build the Maven project
RUN mvn clean package -P alzza -DskipTests

# Step 2: Runtime stage - OpenJDK 17 (optional JDK 17 image for consistency)
FROM openjdk:17-jdk-alpine  # JDK 17 for consistency

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar /app/my-app-1.0-SNAPSHOT.jar

# Run the JAR file
CMD ["java", "-jar", "/app/my-app-1.0-SNAPSHOT.jar"]
