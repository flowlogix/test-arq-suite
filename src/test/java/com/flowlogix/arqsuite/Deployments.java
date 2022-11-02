/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.examples.MyBean;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 *
 * @author lprimak
 */
@ArquillianSuiteDeployment
public class Deployments {
    public static int numOfDeployments;

    @Deployment
    public static WebArchive deploy() {
        ++numOfDeployments;
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(Deployments.class.getPackage())
                .addPackage(MyBean.class.getPackage());
    }
}
