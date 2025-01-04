# Use a base image with OpenJDK 11
FROM openjdk:17

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar /app/app.jar

# Expose the port on which your Spring Boot application is running
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
