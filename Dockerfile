# Step 1: Build stage
FROM maven:3.8.4-openjdk-17 AS build # JDK 17로 변경 (JAR 실행에 적합)
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -P alzza -DskipTests

# Step 2: Runtime stage
FROM openjdk:17-jdk # Tomcat 대신 OpenJDK 사용
WORKDIR /app

# JAR 파일 복사
COPY --from=build /app/target/*.jar app.jar

# JAR 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]