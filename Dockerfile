FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY target/book-service.jar /app/app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
