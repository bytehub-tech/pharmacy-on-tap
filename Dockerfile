FROM amazoncorretto:11-alpine
RUN mkdir /app
COPY target/pharmacy-on-tap-*.jar /app/pharmacy-on-tap.jar
EXPOSE 5000
WORKDIR /app
ENTRYPOINT ["java", "-jar", "pharmacy-on-tap.jar"]