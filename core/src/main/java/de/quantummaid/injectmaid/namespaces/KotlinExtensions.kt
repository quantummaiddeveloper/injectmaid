/**
 * Copyright (c) 2021 Richard Hauswald - https://quantummaid.de/.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package de.quantummaid.injectmaid.namespaces

import de.quantummaid.injectmaid.InjectMaid
import de.quantummaid.injectmaid.InjectMaidBuilder
import de.quantummaid.injectmaid.api.ReusePolicy
import de.quantummaid.injectmaid.api.ReusePolicy.PROTOTYPE
import de.quantummaid.injectmaid.api.customtype.api.Builder
import de.quantummaid.injectmaid.api.customtype.api.CustomType
import de.quantummaid.injectmaid.api.customtype.api.CustomType.customType
import de.quantummaid.injectmaid.api.customtype.api.FactoryBuilder00
import de.quantummaid.injectmaid.timing.TimedInstantiation
import de.quantummaid.reflectmaid.GenericType
import de.quantummaid.reflectmaid.GenericType.Companion.genericType

class KotlinExtensions<Namespace>(val namespace: GenericType<Namespace>, val injectMaidBuilder: InjectMaidBuilder) {

    companion object {
        inline fun <reified Type : Any> InjectMaid.getInstance(): Type {
            val type = genericType<Type>()
            return getInstance(type)
        }

        inline fun <reified Type : Any> InjectMaid.getInstanceWithInitializationTime(): TimedInstantiation<Type> {
            val type = genericType<Type>()
            return getInstanceWithInitializationTime(type)
        }
    }
}
