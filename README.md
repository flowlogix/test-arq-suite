# Running Arquillian Suite test

## TestContainers
This example uses an updated version of Payara Arquillian Connectors for TestContainers.

To use it, add the following into your `~/.m2/settings.xml`:
```
<profiles>
    <profile>
        <id>payara-arquillian-version-override</id>
        <properties>
            <arquillian.payara.version>3.0.alpha9-lp-feb9-2</arquillian.payara.version>
        </properties>

        <repositories>
            <repository>
                <id>hope-releases</id>
                <url>https://nexus.hope.nyc.ny.us/repository/maven-releases</url>
            </repository>
        </repositories>
    </profile>
<profiles>
```
