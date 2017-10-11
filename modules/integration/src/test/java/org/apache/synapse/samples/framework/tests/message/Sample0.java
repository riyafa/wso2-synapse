/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.synapse.samples.framework.tests.message;

import org.apache.synapse.samples.framework.SampleClientResult;
import org.apache.synapse.samples.framework.SynapseTestCase;

public class Sample0 extends SynapseTestCase {

    public Sample0() {
        super(0);
    }


    public void testSmartClientMode() {
        String addUrl = "http://192.168.88.81:9000/services/SimpleStockQuoteService";
        String trpUrl = "http://localhost:8280/";

        log.info("Running test: Smart Client mode");
        SampleClientResult result = getStockQuoteClient().requestStandardQuote(
                addUrl, trpUrl, null, "IBM" ,null);
        assertResponseReceived(result);
    }


    public void testSynapseAsHTTPProxy() {
        String addUrl = "http://192.168.88.81:9000/services/SimpleStockQuoteService";
        String prxUrl = "http://localhost:8280/";

        log.info("Running test: Using Synapse as a HTTP Proxy");
        SampleClientResult result = getStockQuoteClient().requestStandardQuote(
                addUrl, null, prxUrl, "IBM", null);
        assertResponseReceived(result);
    }

}
