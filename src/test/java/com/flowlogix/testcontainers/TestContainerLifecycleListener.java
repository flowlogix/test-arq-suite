/*
 * Copyright (C) 2011-2024 Flow Logix, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
    @SuppressWarnings("checkstyle:MagicNumber")
    public void testRunStarted(Description description) throws Exception {
        payara = new GenericContainer<>(DockerImageName.parse(
                System.getProperty("imageName", "payara/server-full")))
                .withExposedPorts(4848, 8080, 8181)
                .waitingFor(Wait.forLogMessage(".*Payara Server.*startup time.*\\n", 1));
        payara.start();
        System.setProperty("adminHost", payara.getHost());
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
