# Running Arquillian Suite test

## TestContainers
This example uses an updated version of Payara Arquillian Connectors for TestContainers.

To use it, add the following into your `~/.m2/settings.xml`:
```
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <activeProfiles>
        <activeProfile>payara-arquillian-version-override</activeProfile>
        <activeProfile>hope-repository</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>hope-repository</id>
            <repositories>
                <repository>
                    <id>hope-repository</id>
                    <url>https://nexus.hope.nyc.ny.us/repository/maven-releases</url>
                    <releases>
                        <enabled>true</enabled>
                        <checksumPolicy>fail</checksumPolicy>
                    </releases>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                </repository>
            </repositories>
        </profile>

        <profile>
            <id>payara-arquillian-version-override</id>
            <properties>
                <arquillian.payara.version>3.0.alpha9-lp-feb9-2</arquillian.payara.version>
            </properties>
        </profile>

    </profiles>
</settings>
```
