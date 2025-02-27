# 1단계: Maven 빌드 환경11223344
FROM maven:3.6.3-openjdk-17 AS builder

WORKDIR /app

# 프로젝트 소스 코드 복사
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Maven으로 프로젝트 빌드
RUN mvn clean package -DskipTests

# 2단계: 런타임 환경 (JDK만 포함)
FROM openjdk:17-jdk-slim

WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/target/*.jar app.jar

# 컨테이너 실행 시 JAR 실행
CMD ["java", "-jar", "app.jar"]
