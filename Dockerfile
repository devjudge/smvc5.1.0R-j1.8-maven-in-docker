FROM maven:3.6.3-slim AS MAVEN_TOOL_CHAIN

RUN apt-get update \
    && apt-get install --assume-yes wget bash-completion unzip

# Pre build commands
USER root
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/spring-mvc/maven/pre-build.sh
RUN chmod 775 ./pre-build.sh
RUN sh pre-build.sh

COPY . /tmp
WORKDIR /tmp/

EXPOSE 8080

# Build the app
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/spring-mvc/maven/build.sh
RUN chmod 775 ./build.sh
RUN sh build.sh

# Add extra docker commands here (if any)...

# Run the app
RUN wget https://codejudge-starter-repo-artifacts.s3.ap-south-1.amazonaws.com/backend-project/spring-mvc/maven/run.sh
RUN chmod 775 ./run.sh
CMD sh run.sh