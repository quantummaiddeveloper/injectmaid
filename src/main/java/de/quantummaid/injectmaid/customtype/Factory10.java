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

package de.quantummaid.injectmaid.customtype;

@SuppressWarnings({"java:S107", "java:S109"})
public interface Factory10<X, A, B, C, D, E, F, G, H, I, J> extends InvocableFactory<X> {

    X create(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j);

    @SuppressWarnings("unchecked")
    @Override
    default X invoke(final Object[] dependencies) {
        return create(
                (A) dependencies[0],
                (B) dependencies[1],
                (C) dependencies[2],
                (D) dependencies[3],
                (E) dependencies[4],
                (F) dependencies[5],
                (G) dependencies[6],
                (H) dependencies[7],
                (I) dependencies[8],
                (J) dependencies[9]
        );
    }
}
