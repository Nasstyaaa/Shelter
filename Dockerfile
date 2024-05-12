FROM gradle:7.3.3-jdk17 as builder
WORKDIR /app
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build
FROM openjdk:17
WORKDIR /app
COPY . .
COPY --from=builder /app/build/libs/KR_sem4-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]