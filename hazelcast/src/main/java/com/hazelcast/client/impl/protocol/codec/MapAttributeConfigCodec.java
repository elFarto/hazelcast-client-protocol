/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.annotation.Codec;
import com.hazelcast.annotation.Since;
import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.util.ParameterUtil;
import com.hazelcast.config.MapAttributeConfig;

/**
 * MapAttributeConfig codec
 */
@Codec(MapAttributeConfig.class)
@Since("1.5")
public final class MapAttributeConfigCodec {

    private MapAttributeConfigCodec() {
    }

    public static MapAttributeConfig decode(ClientMessage clientMessage) {
        MapAttributeConfig config = new MapAttributeConfig();
        config.setName(clientMessage.getStringUtf8());
        config.setExtractor(clientMessage.getStringUtf8());
        return config;
    }

    public static void encode(MapAttributeConfig config, ClientMessage clientMessage) {
        clientMessage.set(config.getName()).set(config.getExtractor());
    }

    public static int calculateDataSize(MapAttributeConfig config) {
        int dataSize = ParameterUtil.calculateDataSize(config.getName());
        dataSize += ParameterUtil.calculateDataSize(config.getExtractor());
        return dataSize;
    }
}
