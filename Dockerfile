FROM docker.io/maven:3.9-eclipse-temurin-11 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM docker.io/eclipse-temurin:11-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/poc-java-app-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
