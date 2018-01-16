FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

RUN mvn -f /app/pom.xml clean package -Dlibrary.db.host.name=${VAR_HOST}

CMD echo "The application will start in ${VAR_SLEEP}s..." && \
    sleep ${VAR_SLEEP} && \
    java -jar target/library-api-0.1.0.jar
