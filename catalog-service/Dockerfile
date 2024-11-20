# 첫 번째 스테이지: 빌드 스테이지
FROM gradle:jdk21-graal-jammy AS builder
# 작업 디렉토리 설정
WORKDIR /workspace

# Gradle 래퍼와 설정 파일 복사
COPY gradlew gradlew
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Gradle 래퍼에 실행 권한 부여
RUN chmod +x gradlew

# 의존성 설치 (캐싱 활용)
RUN ./gradlew dependencies --no-daemon

# 소스 코드 복사 및 애플리케이션 빌드
COPY src src
RUN ./gradlew build -x test --no-daemon

# 두 번째 스테이지: 실행 스테이지
FROM container-registry.oracle.com/graalvm/jdk:21
# 작업 디렉토리 설정
WORKDIR /workspace
# 빌드 결과 복사
COPY --from=builder /workspace/build/libs/*.jar app.jar
# 실행할 JAR 파일 지정
ENTRYPOINT ["java", "-jar", "app.jar"]
