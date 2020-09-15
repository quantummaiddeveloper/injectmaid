/*
 * Copyright (c) 2020 Richard Hauswald - https://quantummaid.de/.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
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

package de.quantummaid.injectmaid;

import de.quantummaid.injectmaid.domain.StringWrapper;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public final class ConstantsSpecs {

    @Test
    public void injectMaidSupportsConstants() {
        final InjectMaid injectMaid = InjectMaid.anInjectMaid()
                .withCustomType(StringWrapper.class, () -> new StringWrapper("foo"), ReusePolicy.SINGLETON)
                .build();
        final StringWrapper instance = injectMaid.getInstance(StringWrapper.class);
        assertThat(instance, notNullValue());
        assertThat(instance, instanceOf(StringWrapper.class));
        assertThat(instance.string, is("foo"));
    }

    @Test
    public void aConstantCanBeNull() {
        final InjectMaid injectMaid = InjectMaid.anInjectMaid()
                .withCustomType(StringWrapper.class, () -> null, ReusePolicy.SINGLETON)
                .build();
        final StringWrapper instance = injectMaid.getInstance(StringWrapper.class);
        assertThat(instance, nullValue());
    }
}
