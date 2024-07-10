# Use OpenJDK 21 as the base image
FROM openjdk:21-jre-slim

# Set the working directory
WORKDIR /app

# Copy the Spring Boot jar file to the container
COPY target/qthreads.jar /app/qthreads.jar

# Expose the port the application will run on
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/qthreads.jar"]
