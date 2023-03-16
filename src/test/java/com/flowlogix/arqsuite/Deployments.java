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
public class Deployments {
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
