// Copyright 2020 Purcell Informatics Limited
//
// See the LICENCE file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package day04

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Test
    fun testIsValidEcl() {
        assertTrue(validateEcl("brn"))
        assertFalse(validateEcl("wat"))
        assertFalse(validateEcl(null))
    }

    @Test
    fun testIsValidPid() {
        assertTrue(validatePid("000000001"))
        assertFalse(validatePid("0123456789"))
    }

    @Test
    fun testIsValidEyr() {
        assertTrue(validateEyr("2020"))
        assertTrue(validateEyr("2025"))
        assertTrue(validateEyr("2030"))
        assertFalse(validateEyr("2019"))
        assertFalse(validateEyr("2035"))
    }

    @Test
    fun testIsValidHcl() {
        assertTrue(validateHcl("#123abc"))
        assertFalse(validateHcl("#123abz"))
        assertFalse(validateHcl("123abc"))
    }

    @Test
    fun testIsValidByr() {
        assertTrue(validateByr("1920"))
        assertTrue(validateByr("1974"))
        assertTrue(validateByr("2002"))
        assertFalse(validateByr("1919"))
        assertFalse(validateByr("2003"))
    }

    @Test
    fun testIsValidIyr() {
        assertTrue(validateIyr("2010"))
        assertTrue(validateIyr("2015"))
        assertTrue(validateIyr("2020"))
        assertFalse(validateIyr("2009"))
        assertFalse(validateIyr("2021"))
    }

    @Test
    fun testIsValidHgt() {
        assertTrue(validateHgt("60in"))
        assertTrue(validateHgt("190cm"))
        assertFalse(validateHgt("190in"))
        assertFalse(validateHgt("190"))
    }

}
