FROM amazoncorretto:11
EXPOSE 8080
WORKDIR /app
COPY target/application-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","application-0.0.1-SNAPSHOT.jar"]