# OpenJDK 17 이미지를 기반으로 설정11
FROM openjdk:17-jdk

# /tmp 디렉토리를 볼륨으로 설정
VOLUME /tmp

# 빌드된 JAR 파일의 경로를 설정
ARG JAR_FILE=target/*.jar

# JAR 파일을 컨테이너에 복사
COPY ${JAR_FILE} app.jar

# 컨테이너 시작 시 JAR 파일 실행
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
