package com.softartdev.sqlcipherktnpod

import kotlin.test.Test
import kotlin.test.assertTrue
import sqlite3.*
import kotlin.test.assertFalse

class PodAvailableTest {

    @Test
    fun podIsAvailableTest() {
        assertFalse(actual = TestUtil().checkKey("pass", "testdb"))
        assertTrue(actual = SQLITE_ERROR != SQLITE_OK)
    }
}