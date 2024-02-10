/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.testcontainers;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author lprimak
 */
public class TestContainerLifecycleListener extends RunListener {
    private static GenericContainer<?> payara;

    @Override
    public void testRunStarted(Description description) throws Exception {
        payara = new GenericContainer<>(DockerImageName.parse(
                System.getProperty("imageName", "payara/server-full")))
                .withExposedPorts(4848, 8080, 8181)
                .waitingFor(Wait.forLogMessage(".*Payara Server.*startup time.*\\n", 1));
        payara.start();
        System.setProperty("adminPort", Integer.toString(payara.getMappedPort(4848)));
        System.setProperty("httpPort", Integer.toString(payara.getMappedPort(8080)));
        System.setProperty("httpsPort", Integer.toString(payara.getMappedPort(8181)));
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        if (payara != null) {
            Runtime.getRuntime().addShutdownHook(new Thread(payara::stop));
            payara = null;
        }
    }
}
