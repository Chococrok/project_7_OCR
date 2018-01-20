FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn -f /app/pom.xml clean package -Dlibrary.db.host=${VAR_DB_HOST} && \
    echo "The application will start in ${VAR_SLEEP}s..." && \
    echo "The web servicce is connected to: " && \
    echo ${VAR_DB_HOST} && \
    sleep ${VAR_SLEEP} && \
    java -jar target/library-api-0.1.0.jar
