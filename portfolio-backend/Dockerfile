# Build stage
FROM maven:3.9.1 AS build
WORKDIR /app

# Installer Java 21 si nécessaire
RUN apt-get update && \
    apt-get install -y openjdk-21-jdk && \
    apt-get clean;

ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="$JAVA_HOME/bin:$PATH"

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
