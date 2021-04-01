package com.softartdev.sqlcipherktnpod

import cnames.structs.sqlite3
//import cocoapods.SQLCipher.*
import kotlinx.cinterop.*

class TestUtil {

    fun checkCocoapodsIsAvailable(): Boolean {
        var result = false
        memScoped {
            val db = allocPointerTo<sqlite3>()
            val key = "".cstr
//            val rc: Int = sqlite3_key(db.value, key.ptr, key.size)
//            result = rc != SQLITE_OK
//            result = SQLITE_ERROR != SQLITE_OK
        }
        return result
    }
}