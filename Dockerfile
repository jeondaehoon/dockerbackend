# 1. 기본 이미지로 OpenJDK 11을 사용
FROM openjdk:11-jre-slim

# 2. Maven 설치
RUN apt-get update && apt-get install -y maven

# 3. 작업 디렉토리 설정
WORKDIR /app

# 4. Maven 빌드 파일을 복사
COPY pom.xml .

# 5. 종속성만 먼저 다운로드하여 캐시를 사용하여 빌드 최적화
RUN mvn dependency:go-offline

# 6. 전체 프로젝트 파일을 복사
COPY . .

# 7. Maven으로 프로젝트 빌드 (패키징)
RUN mvn clean package -DskipTests

# 8. 빌드된 JAR 파일을 실행
CMD ["java", "-jar", "target/your-app-name.jar"]

# 9. 컨테이너가 외부와 연결될 포트 설정
EXPOSE 8080
