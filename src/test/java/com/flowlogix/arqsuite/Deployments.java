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

import com.flowlogix.util.ShrinkWrapManipulator;
import org.eu.ingwar.tools.arquillian.extension.suite.annotations.ArquillianSuiteDeployment;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static com.flowlogix.arqsuite.extensions.DeploymentExtension.numOfDeployments;

/**
 *
 * @author lprimak
 */
@ArquillianSuiteDeployment
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
class Deployments {
    @Deployment
    static WebArchive deploy() {
        ++numOfDeployments;
        var archive = ShrinkWrapManipulator.createDeployment(WebArchive.class)
                .addPackage(Deployments.class.getPackage());
        return ShrinkWrapManipulator.packageSlf4j(archive);
    }
}
