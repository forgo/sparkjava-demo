FROM java:8

ARG PORT
ARG KEYSTORE_SRC
ARG KEYSTORE_DST

COPY build/libs/app.jar /app.jar
COPY ${KEYSTORE_SRC} ${KEYSTORE_DST}

EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar"]