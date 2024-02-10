/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.utility.DockerImageName;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 *
 * @author lprimak
 */
@Test(groups = "TestContainers")
public class ContainerStartTest {
    private  static GenericContainer<?> payara;

    @BeforeSuite
    public void beforeAll() {
        if (payara == null) {
            payara = new GenericContainer<>(DockerImageName.parse(
                    System.getProperty("imageName", "payara/server-full")))
                    .withExposedPorts(4848, 8080, 8181)
                    .waitingFor(Wait.forLogMessage(".*Payara Server.*startup time.*\\n", 1));
            payara.start();
            System.setProperty("adminPort", Integer.toString(payara.getMappedPort(4848)));
            System.setProperty("httpPort", Integer.toString(payara.getMappedPort(8080)));
            System.setProperty("httpsPort", Integer.toString(payara.getMappedPort(8181)));
        }
    }

    @Test
    void dummy() {

    }
}
