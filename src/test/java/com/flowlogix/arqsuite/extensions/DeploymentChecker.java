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
package com.flowlogix.arqsuite.extensions;

import com.flowlogix.arqsuite.Deployments;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeploymentChecker implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put(this.getClass().getName(), this);
    }

    @Override
    public void close() throws Throwable {
        assertEquals(1, Deployments.numOfDeployments, "Should only be one deployment");
    }
}
