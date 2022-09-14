/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.testcontainers.FixedPortContainer;
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
            payara = new FixedPortContainer<>(DockerImageName.parse("payara/server-full:5.2022.3-jdk17"))
                    .withFixedExposedPort(4848, 4848)
                    .withFixedExposedPort(8080, 8080)
//                    .withReuse(true)
                    .waitingFor(Wait.forLogMessage(".*Payara Server.*startup time.*\\n", 1));
            payara.start();
        }
    }

    @Test
    void dummy() {

    }
}
