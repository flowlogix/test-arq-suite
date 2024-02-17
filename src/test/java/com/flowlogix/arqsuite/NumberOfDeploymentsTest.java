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
        if (false) {
            // Arquillian suite currently does not work with Vintage engine
            assertEquals("Should only be one deployment", 1, Deployments.numOfDeployments);
        }
    }

    @Test
    public void dummy() {

    }
}
