#!/bin/bash
# Copyright 2019 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eo pipefail

## Get the directory of the build script
scriptDir=$(realpath $(dirname "${BASH_SOURCE[0]}"))
## cd to the parent directory, i.e. the root of the git repo
cd ${scriptDir}/..

# include common functions
source ${scriptDir}/common.sh

# Kokoro integration test uses both JDK 11 and JDK 8. GraalVM dependencies
# require JDK 11 to compile the classes touching GraalVM classes.
if [ -n "${JAVA11_HOME}" ]; then
  setJava "${JAVA11_HOME}"
fi

# Print out Maven & Java version
mvn -version
echo ${JOB_TYPE}

# attempt to install 3 times with exponential backoff (starting with 10 seconds)
retry_with_backoff 3 10 \
  mvn install -B -V -ntp \
    -DskipTests=true \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dmaven.javadoc.skip=true \
    -Dgcloud.download.skip=true \
    -T 1C

# if GOOGLE_APPLICATION_CREDENTIALS is specified as a relative path, prepend Kokoro root directory onto it
if [[ ! -z "${GOOGLE_APPLICATION_CREDENTIALS}" && "${GOOGLE_APPLICATION_CREDENTIALS}" != /* ]]; then
    export GOOGLE_APPLICATION_CREDENTIALS=$(realpath ${KOKORO_GFILE_DIR}/${GOOGLE_APPLICATION_CREDENTIALS})
fi

# Start the Spanner emulator if the environment variable for it has been set.
# TODO: Change if statement once the env var can be set in the config.
#if [[ ! -z "${SPANNER_EMULATOR_HOST}" ]]; then
if [[ "$JOB_TYPE" == "graalvm" ]] || [[ "$JOB_TYPE" == "graalvm17" ]]; then
  echo "Starting emulator"
  export SPANNER_EMULATOR_HOST=localhost:9010
  docker pull gcr.io/cloud-spanner-emulator/emulator
  docker run -d --rm --name spanner-emulator -p 9010:9010 -p 9020:9020 gcr.io/cloud-spanner-emulator/emulator
fi

# Kokoro integration test uses both JDK 11 and JDK 8. We ensure the generated class files
# are compatible with Java 8 when running tests.
if [ -n "${JAVA8_HOME}" ]; then
  setJava "${JAVA8_HOME}"
fi

RETURN_CODE=0
set +e

case ${JOB_TYPE} in
test)
    # Maven surefire plugin (unit tests) allows us to specify JVM to run the tests.
    # https://maven.apache.org/surefire/maven-surefire-plugin/test-mojo.html#jvm
    # If we rely on certain things only available in newer JVM than Java 8, this
    # tests detect the usage.
    echo "SUREFIRE_JVM_OPT: ${SUREFIRE_JVM_OPT}"
    mvn test -B -V \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Djava.net.preferIPv4Stack=true \
      ${SUREFIRE_JVM_OPT}
    RETURN_CODE=$?
    ;;
lint)
    mvn com.spotify.fmt:fmt-maven-plugin:check
    RETURN_CODE=$?
    ;;
javadoc)
    mvn javadoc:javadoc javadoc:test-javadoc
    RETURN_CODE=$?
    ;;
integration)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.gce.config.project_id=gcloud-devel \
      -Dspanner.testenv.instance=projects/gcloud-devel/instances/java-client-integration-tests \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
integration-directpath-enabled)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.testenv.instance=projects/span-cloud-testing/instances/spanner-java-client-directpath \
      -Dspanner.gce.config.project_id=span-cloud-testing \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
integration-multiplexed-sessions-enabled)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.gce.config.project_id=gcloud-devel \
      -Dspanner.testenv.instance=projects/gcloud-devel/instances/java-client-integration-tests-multiplexed-sessions \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
integration-cloud-devel)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.gce.config.server_url=https://staging-wrenchworks.sandbox.googleapis.com \
      -Dspanner.testenv.instance=projects/span-cloud-testing/instances/spanner-java-client-testing \
      -Dspanner.gce.config.project_id=span-cloud-testing \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
integration-cloud-devel-directpath-enabled)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.gce.config.server_url=https://staging-wrenchworks.sandbox.googleapis.com \
      -Dspanner.testenv.instance=projects/span-cloud-testing/instances/cloud-spanner-java-directpath \
      -Dspanner.gce.config.project_id=span-cloud-testing \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
integration-cloud-staging|integration-cloud-staging-directpath-enabled)
    mvn -B ${INTEGRATION_TEST_ARGS} \
      -ntp \
      -Penable-integration-tests \
      -Djava.net.preferIPv4Stack=true \
      -DtrimStackTrace=false \
      -Dclirr.skip=true \
      -Denforcer.skip=true \
      -Dmaven.main.skip=true \
      -Dspanner.gce.config.server_url=https://preprod-spanner.sandbox.googleapis.com \
      -Dspanner.testenv.instance=projects/span-cloud-testing/instances/spanner-testing \
      -Dspanner.gce.config.project_id=span-cloud-testing \
      -fae \
      verify
    RETURN_CODE=$?
    ;;
graalvm)
    # Run Unit and Integration Tests with Native Image
    mvn test -Pnative -Penable-integration-tests -Dspanner.gce.config.project_id=gcloud-devel -Dspanner.testenv.instance=projects/gcloud-devel/instances/java-client-integration-tests
    RETURN_CODE=$?
    ;;
graalvm17)
    # Run Unit and Integration Tests with Native Image
    mvn test -Pnative -Penable-integration-tests -Dspanner.gce.config.project_id=gcloud-devel -Dspanner.testenv.instance=projects/gcloud-devel/instances/java-client-integration-tests
    RETURN_CODE=$?
    ;;
slowtests)
  mvn -B ${INTEGRATION_TEST_ARGS} \
    -ntp \
    -Pslow-tests \
    -Djava.net.preferIPv4Stack=true \
    -DskipITs=false \
    -DtrimStackTrace=false \
    -Dclirr.skip=true \
    -Denforcer.skip=true \
    -Dmaven.main.skip=true \
    -fae \
    verify
  RETURN_CODE=$?
  ;;
samples|samples-slow-tests)
    SAMPLES_DIR=samples
    PROFILES=''
    # only run ITs in snapshot/ on presubmit PRs. run ITs in all 3 samples/ subdirectories otherwise.
    if [[ ! -z ${KOKORO_GITHUB_PULL_REQUEST_NUMBER} ]]
    then
      SAMPLES_DIR=samples/snapshot
    elif [[ ${JOB_TYPE} = 'samples-slow-tests' ]]
    then
      SAMPLES_DIR=samples/snippets
      PROFILES='-Pslow-tests,!integration-tests'
    fi

    if [[ -f ${SAMPLES_DIR}/pom.xml ]]
    then
        for FILE in ${KOKORO_GFILE_DIR}/secret_manager/*-samples-secrets; do
          [[ -f "$FILE" ]] || continue
          source "$FILE"
        done

        pushd ${SAMPLES_DIR}
        mvn -B \
          -ntp \
          -DtrimStackTrace=false \
          -Dclirr.skip=true \
          -Denforcer.skip=true \
          ${PROFILES} \
          -fae \
          verify
        RETURN_CODE=$?
        popd
    else
        echo "no sample pom.xml found - skipping sample tests"
    fi
    ;;
clirr)
    mvn -B -Denforcer.skip=true clirr:check
    RETURN_CODE=$?
    ;;
*)
    ;;
esac

if [[ ! -z "${SPANNER_EMULATOR_HOST}" ]]; then
  echo "Stopping emulator"
  docker container stop spanner-emulator
fi

if [ "${REPORT_COVERAGE}" == "true" ]
then
  bash ${KOKORO_GFILE_DIR}/codecov.sh
fi

# fix output location of logs
bash .kokoro/coerce_logs.sh

if [[ "${ENABLE_FLAKYBOT}" == "true" ]]
then
    chmod +x ${KOKORO_GFILE_DIR}/linux_amd64/flakybot
    ${KOKORO_GFILE_DIR}/linux_amd64/flakybot -repo=googleapis/java-spanner
fi

echo "exiting with ${RETURN_CODE}"
exit ${RETURN_CODE}
