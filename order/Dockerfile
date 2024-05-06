FROM maven:3.8.4-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:17

EXPOSE 8083

COPY --from=builder /app/target/order-0.0.1-SNAPSHOT.jar order.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=dev", "/order.jar"]