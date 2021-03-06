/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.  The ASF licenses this file to you under the Apache License, Version
 * 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package org.apache.storm.jms.spout;

import java.io.Serializable;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
public class JmsMessageID implements Comparable<JmsMessageID>, Serializable {

    private final String jmsId;

    private final Long sequence;

    public JmsMessageID(long sequence, String jmsId) {
        this.jmsId = jmsId;
        this.sequence = sequence;
    }

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public String getJmsID() {
        return this.jmsId;
    }

    @Override
    public int compareTo(JmsMessageID jmsMessageID) {
        return (int) (this.sequence - jmsMessageID.sequence);
    }

    @Override
    public int hashCode() {
        return this.sequence.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof JmsMessageID) {
            JmsMessageID id = (JmsMessageID) o;
            return this.jmsId.equals(id.jmsId);
        } else {
            return false;
        }
    }

}
