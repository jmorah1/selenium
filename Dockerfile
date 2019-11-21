FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/automation

ADD target/selenium-docker.jar         selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs                        libs
ADD Environments.properties            Environments.properties

ADD smoketest.xml           smoketest.xml
ADD verifyhubrunsuite.sh    verifyhubrunsuite.sh

ENTRYPOINT sh verifyhubrunsuite.sh