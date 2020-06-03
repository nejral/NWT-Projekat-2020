FROM openjdk:8-jre-slim
RUN groupadd -g 12000 reservation && \
    useradd -r -u 11000 -g reservation reservation
USER 11000
VOLUME /tmp
EXPOSE 8082
EXPOSE 8088
WORKDIR /home/reservation
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /home/reservation/app.jar"]