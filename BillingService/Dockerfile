FROM openjdk:8-jre-slim
RUN groupadd -g 12000 billing && \
    useradd -r -u 11000 -g billing billing
USER 11000
VOLUME /tmp
EXPOSE 8090
EXPOSE 8081
WORKDIR /home/billing
ADD target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /home/billing/app.jar"]