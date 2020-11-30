/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.testcontainers.MyFixedPortContainer;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author lprimak
 */
@Ignore
public class ContainerStartTest {
    public static GenericContainer<?> payara;

    @BeforeClass
    public static void start() {
        payara = new MyFixedPortContainer<>(DockerImageName.parse("payara/server-full"))
            .withFixedExposedPort(4848, 4848)
            .withFixedExposedPort(8080, 8080);
        payara.start();
    }

    @Test
    public void dummy() {

    }
}
