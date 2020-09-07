FROM openjdk:11.0.4-jre-slim
ENV TZ=America/Lima
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /app
COPY build/libs/*.jar /app/ms-shop-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/ms-shop-0.0.1-SNAPSHOT.jar"]



