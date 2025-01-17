FROM eclipse-temurin:17-alpine

RUN mkdir /opt/app

COPY target/j2html-generator-0.0.3-SNAPSHOT.jar /opt/app

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/j2html-generator-0.0.3-SNAPSHOT.jar"]