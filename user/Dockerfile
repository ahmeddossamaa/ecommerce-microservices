FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:17

EXPOSE 8081

COPY --from=builder /app/target/user-0.0.1-SNAPSHOT.jar user.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/user.jar"]