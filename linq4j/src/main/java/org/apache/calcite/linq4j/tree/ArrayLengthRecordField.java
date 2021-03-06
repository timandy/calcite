/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.linq4j.tree;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * Represents a length field of a RecordType
 */
public class ArrayLengthRecordField implements Types.RecordField {
    private final String fieldName;
    private final Class clazz;

    public ArrayLengthRecordField(String fieldName, Class clazz) {
        assert fieldName != null : "fieldName should not be null";
        assert clazz != null : "clazz should not be null";
        this.fieldName = fieldName;
        this.clazz = clazz;
    }

    public boolean nullable() {
        return false;
    }

    public String getName() {
        return fieldName;
    }

    public Type getType() {
        return int.class;
    }

    public int getModifiers() {
        return 0;
    }

    public Object get(Object o) throws IllegalAccessException {
        return Array.getLength(o);
    }

    public Type getDeclaringClass() {
        return clazz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ArrayLengthRecordField that = (ArrayLengthRecordField) o;

        return clazz.equals(that.clazz) && fieldName.equals(that.fieldName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, clazz);
    }
}

// End ArrayLengthRecordField.java
