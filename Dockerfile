# Stage 1: Clone the repository and build the application
FROM gradle:7.3.1-jdk11 AS build
WORKDIR /app
RUN git clone https://github.com/Tristan-H11/Schiessanlage-Schuefe-Server.git .
RUN gradle clean build

# Stage 2: Run the application
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]