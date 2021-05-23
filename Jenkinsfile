pipeline {
    agent any

    options {
        quietPeriod 120
    }

    stages {
        stage('Maven Verify - Tests') {
            steps {
                withMaven {
                    sh """\
                    MAVEN_OPTS="$JAVA_TOOL_OPTIONS" \
                    env -u JAVA_TOOL_OPTIONS \
                    mvn verify -fae -Ppayara-local \
                    -Dmaven.test.failure.ignore=true -DtrimStackTrace=false \
                    -Dmaven.install.skip=true \
                    """
                }
            }
        }
    }
}
