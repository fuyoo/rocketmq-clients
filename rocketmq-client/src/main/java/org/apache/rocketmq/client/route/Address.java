/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.client.route;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
public class Address {
    private final String host;
    private final int port;

    public Address(apache.rocketmq.v1.Address address) {
        this.host = address.getHost();
        this.port = address.getPort();
    }

    public Address(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getAddress() {
        return host + ":" + port;
    }

    public apache.rocketmq.v1.Address toPbAddress() {
        return apache.rocketmq.v1.Address.newBuilder().setHost(host).setPort(port).build();
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return port == address.port && Objects.equal(host, address.host);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(host, port);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("host", host)
                          .add("port", port)
                          .toString();
    }
}
