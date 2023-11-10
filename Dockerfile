# Use the official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Define an environment variable for the JAR file name
ENV JAR_FILE=Lab01-0.0.1-SNAPSHOT.jar

# Copy the application JAR file into the container
COPY target/$JAR_FILE /app/$JAR_FILE

# Expose the port that your application will run on
EXPOSE 8080

# Specify the command to run on container startup
CMD java -jar $JAR_FILE
