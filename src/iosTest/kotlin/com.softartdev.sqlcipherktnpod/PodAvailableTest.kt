package com.softartdev.sqlcipherktnpod

import kotlin.test.Test
import kotlin.test.assertTrue
import cocoapods.SQLCipher.*

class PodAvailableTest {

    @Test
    fun podIsAvailableTest() {
//        assertTrue(actual = TestUtil().checkCocoapodsIsAvailable())
        assertTrue(actual = SQLITE_ERROR != SQLITE_OK)
    }
}