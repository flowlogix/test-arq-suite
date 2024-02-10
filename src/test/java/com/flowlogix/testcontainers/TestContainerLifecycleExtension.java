package com.flowlogix.testcontainers;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author lprimak
 */
public class TestContainerLifecycleExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    private static GenericContainer<?> payara;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (payara == null) {
            payara = new GenericContainer<>(DockerImageName.parse(
                    System.getProperty("imageName", "payara/server-full")))
                    .withExposedPorts(4848, 8080, 8181)
                    .waitingFor(Wait.forLogMessage(".*Payara Server.*startup time.*\\n", 1));
            payara.start();
            System.setProperty("adminPort", Integer.toString(payara.getMappedPort(4848)));
            System.setProperty("httpPort", Integer.toString(payara.getMappedPort(8080)));
            System.setProperty("httpsPort", Integer.toString(payara.getMappedPort(8181)));
            context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("TestContaiersContext", this);
        }
    }

    @Override
    public void close() throws Throwable {
        payara.stop();
        payara = null;
    }
}
