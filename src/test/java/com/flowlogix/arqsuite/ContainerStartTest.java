/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flowlogix.arqsuite;

import com.flowlogix.testcontainers.TestContainerLifecycleExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author lprimak
 */
@Tag("TestContainers")
@ExtendWith(TestContainerLifecycleExtension.class)
public class ContainerStartTest {
    @Test
    void dummy() {

    }
}
