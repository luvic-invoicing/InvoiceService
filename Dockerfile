## fetch basic image
FROM openjdk:8-jdk-alpine

# local application port
EXPOSE 8025

# application placed into /opt/app
RUN mkdir -p /opt/service
WORKDIR /opt/service

# The application's jar file
ARG JAR_FILE=target/InvoiceService-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} invoice-service.jar


# Run the jar file
#CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/keygenerator-service.jar"]
CMD java -jar invoice-service.jar


