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
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author lprimak
 */
public class TestContainerLifecycleListener extends RunListener {
    private static GenericContainer<?> payara;

    @Override
    public void testRunStarted(Description description) throws Exception {
        payara = new FixedPortContainer<>(DockerImageName.parse("payara/server-full"))
                .withFixedExposedPort(4848, 4848)
                .withFixedExposedPort(8080, 8080);
        payara.start();
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        if (payara != null) {
            Runtime.getRuntime().addShutdownHook(new Thread(payara::stop));
            payara = null;
        }
    }
}
