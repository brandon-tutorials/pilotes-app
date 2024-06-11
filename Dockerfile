
FROM maven:3.9.7-eclipse-temurin-17-focal AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn install
EXPOSE 8080
CMD ["java", "-jar", "target/pilotes-app-0.0.1-SNAPSHOT.jar"]