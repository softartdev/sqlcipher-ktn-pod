package com.softartdev.sqlcipherktnpod

import kotlin.test.Test
import kotlin.test.assertTrue

class PodAvailableTest {

    @Test
    fun podIsAvailableTest() {
        assertTrue(actual = Util().checkCocoapodsIsAvailable())
    }
}