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
package com.flowlogix.arqsuite;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.slf4j.Logger;

/**
 *
 * @author lprimak
 */
@ArquillianSuiteDeployment
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Deployments {
    @SuppressWarnings({"checkstyle:VisibilityModifier", "checkstyle:JavadocVariable"})
    public static int numOfDeployments;
    private static final String SLF4J_IMPL = "services/org.slf4j.spi.SLF4JServiceProvider";

    @Deployment
    public static WebArchive deploy() {
        ++numOfDeployments;
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(Deployments.class.getPackage())
                .addPackages(true, Logger.class.getPackage())
                .addAsWebInfResource(new StringAsset(
                        "<payara-web-app><class-loader delegate=\"false\"/></payara-web-app>"),
                        "payara-web.xml")
                .addAsWebInfResource(String.format("META-INF/%s", SLF4J_IMPL),
                        String.format("classes/META-INF/%s", SLF4J_IMPL));
        return archive;
    }
}
