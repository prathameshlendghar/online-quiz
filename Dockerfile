# Stage 1
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/online-quiz-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
