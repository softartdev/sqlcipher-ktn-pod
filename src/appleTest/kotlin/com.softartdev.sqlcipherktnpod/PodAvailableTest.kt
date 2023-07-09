package com.softartdev.sqlcipherktnpod

import kotlin.test.Test
import kotlin.test.assertEquals

class PodAvailableTest {

    @Test
    fun cipherVersionTest() {
        assertEquals(expected = "4.5.4 community", actual = checkCipherVersion())
    }
}