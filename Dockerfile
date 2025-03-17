# Use the official Java 17 image as a base
FROM openjdk:22
ARG JAR_FILE=build/libs/\*.jar
COPY ${JAR_FILE} app.jar

# Set the working directory to /app
WORKDIR /app

# Copy the project files into the working directory
COPY . /app

# Expose the port for the application
EXPOSE 8080

# Set the environment variables for the application
ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/pregnancy
ENV SPRING_DATASOURCE_USERNAME=myuser
ENV SPRING_DATASOURCE_PASSWORD=mypassword

# Run the command to start the application when the container starts
CMD ["java", "-jar", "/app.jar"]