/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import javax.annotation.Resource;
import javax.sql.DataSource;
import org.jboss.arquillian.testng.Arquillian;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

/**
 *
 * @author lprimak
 */
class DeploymentOneTest extends Arquillian {
    @Resource
    DataSource ds;

    @Test
    void one() {
        assertNotNull(ds, "resource is null");
    }

    @Test
    void two() {

    }
}
