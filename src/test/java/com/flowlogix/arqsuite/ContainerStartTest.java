/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.testcontainers.MyFixedPortContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

/**
 *
 * @author lprimak
 */
public class ContainerStartTest {
    public static final GenericContainer<?> payara = new MyFixedPortContainer<>(DockerImageName.parse("payara/server-full"))
            .withFixedExposedPort(4848, 4848)
            .withFixedExposedPort(8080, 8080);

    @BeforeAll
    static void start() {
        payara.start();
    }

    @Test
    void dummy() {

    }
}
