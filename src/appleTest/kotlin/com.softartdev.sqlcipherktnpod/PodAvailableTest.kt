package com.softartdev.sqlcipherktnpod

import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.test.Test
import kotlin.test.assertEquals

class PodAvailableTest {

    @Test
    @OptIn(ExperimentalForeignApi::class)
    fun cipherVersionTest() {
        assertEquals(expected = "4.5.4 community", actual = checkCipherVersion())
    }
}