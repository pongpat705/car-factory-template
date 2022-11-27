FROM openjdk:11.0-bullseye

RUN mkdir -p /home/app

ADD target/showroom-0.0.1-SNAPSHOT.jar /home/app/app.jar
# ADD client.truststore.jks /home/app/client.truststore.jks
#ADD application.yaml /home/app/application.yaml

WORKDIR /home/app

EXPOSE 8080

ENTRYPOINT exec java $JAVA_OPTS -jar /home/app/app.jar $JAVA_CONFIGS

