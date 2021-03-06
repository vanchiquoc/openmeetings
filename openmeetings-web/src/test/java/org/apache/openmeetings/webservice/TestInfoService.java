/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openmeetings.webservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.openmeetings.db.dto.basic.Info;
import org.junit.jupiter.api.Test;

public class TestInfoService extends AbstractWebServiceTest {
	private static final String INFO_SERVICE_MOUNT = "info";

	@Test
	public void infoTest() {
		Info info = getClient(getInfoUrl()).path("/version").get(Info.class);
		assertNotNull(info, "Valid info should be returned");
		assertNotNull(info.getBuildDate(), "Valid BuildDate should be returned");
		assertNotNull(info.getRevision(), "Valid Revision should be returned");
		assertNotNull(info.getVersion(), "Valid Version should be returned");
	}

	protected static String getInfoUrl() {
		return getServiceUrl(INFO_SERVICE_MOUNT);
	}
}
