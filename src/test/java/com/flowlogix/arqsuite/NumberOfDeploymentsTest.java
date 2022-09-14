/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 *
 * @author lprimak
 */
class NumberOfDeploymentsTest {
    @AfterClass
    void checkDeployments() {
        assertEquals(1, Deployments.numOfDeployments, "Should only be one deployment");
    }

    @Test
    void dummy() {

    }
}
