package com.softartdev.sqlcipherktnpod

import cocoapods.SQLCipher.SQLITE_ERROR
import cocoapods.SQLCipher.SQLITE_OK
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PodAvailableTest {

    @Test
    fun podIsAvailableTest() {
        assertFalse(actual = TestUtil().checkKey("pass", "testdb"))
        assertTrue(actual = SQLITE_ERROR != SQLITE_OK)
    }
}