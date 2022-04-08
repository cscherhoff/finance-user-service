FROM openjdk:12
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
EXPOSE 8068
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
LABEL prune=true
