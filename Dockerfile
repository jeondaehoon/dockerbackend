# Step 1: Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -P alzza -DskipTests

# Step 2: Runtime stage
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar /app/
ENTRYPOINT ["java", "-jar", "/app/*.jar"]