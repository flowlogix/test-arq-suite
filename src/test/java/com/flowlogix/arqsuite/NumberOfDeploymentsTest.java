/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author lprimak
 */
public class NumberOfDeploymentsTest {
    @AfterClass
    public static void checkDeployments() {
        assertEquals("Should only be one deployment", 1, Deployments.numOfDeployments);
    }

    @Test
    public void dummy() {

    }
}
