/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.slf4j.Logger;

/**
 *
 * @author lprimak
 */
@ArquillianSuiteDeployment
public class Deployments {
    public static int numOfDeployments;
    private static final String SLF4J_IMPL = "services/org.slf4j.spi.SLF4JServiceProvider";

    @Deployment
    public static WebArchive deploy() {

        ++numOfDeployments;
        WebArchive archive = ShrinkWrap.create(WebArchive.class)
                .addPackage(Deployments.class.getPackage())
                .addPackages(true, Logger.class.getPackage())
                .addAsWebInfResource(String.format("META-INF/%s", SLF4J_IMPL),
                        String.format("classes/META-INF/%s", SLF4J_IMPL));
        return archive;
    }
}
