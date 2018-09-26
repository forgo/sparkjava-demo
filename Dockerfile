FROM java:8

# Label Schema Convention
# http://label-schema.org/rc1/
ARG NAME
ARG VERSION
ARG BUILD_DATE
ARG VENDOR
ARG VCS_URL
ARG VCS_REF

# Runtime Listening Port
ARG PORT

# Keystore Mapping
ARG KEYSTORE_SRC
ARG KEYSTORE_DST

LABEL org.label-schema.schema-version=1.0
LABEL org.label-schema.name=${NAME}
LABEL org.label-schema.version=${VERSION}
LABEL org.label-schema.build-date=${BUILD_DATE}
LABEL org.label-schema.vendor=${VENDOR}
LABEL org.label-schema.vcs-url=${VCS_URL}
LABEL org.label-schema.vcs-ref=${VCS_REF}

COPY build/libs/app.jar /app.jar
COPY ${KEYSTORE_SRC} ${KEYSTORE_DST}

EXPOSE ${PORT}
ENTRYPOINT ["java", "-jar", "app.jar"]