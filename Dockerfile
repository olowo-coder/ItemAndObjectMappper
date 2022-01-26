FROM openjdk:17
COPY target/item-app.jar .
ENTRYPOINT ["java", "-jar","/item-app.jar"]