FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn -f /app/pom.xml clean package && \
    echo "The application will start in ${VAR_SLEEP}s..." && \
    echo "The web servicce is connected to: " && \
    echo ${VAR_POSTGRES_SERVICE} && \
    sleep ${VAR_SLEEP} && \
    java -jar target/library-api-*.jar
