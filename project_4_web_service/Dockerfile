FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn -f /app/pom.xml clean package \
		-Dlibrary.postgres.service=${VAR_POSTGRES_SERVICE} \
		-Dlibrary.db.user.name=${VAR_DB_USER_NAME} \
		-Dlibrary.db.user.password=${VAR_DB_USER_PASSWORD} \
		-Dlibrary.property.port=${VAR_WEB_SERVICE_PORT}&& \
    echo "The application will start in ${VAR_SLEEP}s..." && \
    echo "The web servicce is connected to: " && \
    echo ${VAR_POSTGRES_SERVICE} && \
    sleep ${VAR_SLEEP} && \
    java -jar target/library-api-0.1.0.jar
