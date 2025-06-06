/*
 * Copyright (C) 2011-2025 Flow Logix, Inc. All Rights Reserved.
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

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import static org.assertj.core.api.Assertions.assertThat;

public class DeploymentChecker implements BeforeAllCallback, AutoCloseable {
    @SuppressWarnings({"checkstyle:VisibilityModifier", "checkstyle:JavadocVariable"})
    public static int numOfDeployments;

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put(this.getClass().getName(), this);
    }

    @Override
    public void close() {
        // is zero if running in container, which we can safely ignore here
        assertThat(numOfDeployments).withFailMessage("Should only be one deployment").isIn(0, 1);
    }
}
