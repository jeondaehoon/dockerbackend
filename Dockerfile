# OpenJDK 11을 기반으로 이미지를 생성
FROM openjdk:11-jre-slim

# 작업 디렉토리 생성
WORKDIR /app

# Maven 빌드된 JAR 파일을 복사
COPY target/my-app.jar /app/my-app.jar

# 포트 열기 (Spring Boot의 기본 포트 8080)
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "my-app.jar"]
