/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.examples.MyBean;
import javax.inject.Inject;
import org.jboss.arquillian.junit5.ArquillianExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author lprimak
 */
@ExtendWith(ArquillianExtension.class)
class DeploymentTwoTest {
    @Inject
    MyBean bean;

    @Test
    void one() {
        assertEquals("hello", bean.greeting());
    }

    @Test
    void two() {
    }
}
