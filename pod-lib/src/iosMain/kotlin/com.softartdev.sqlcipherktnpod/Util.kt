package com.softartdev.sqlcipherktnpod

import kotlinx.cinterop.memScoped
import cnames.structs.sqlite3
import cocoapods.SQLCipher.*
import kotlinx.cinterop.allocPointerTo
import kotlinx.cinterop.cstr
import kotlinx.cinterop.value

class Util {

    fun checkCocoapodsIsAvailable(): Boolean {
        var result = false
        memScoped {
            val db = allocPointerTo<sqlite3>()
            val key = "".cstr
            val rc: Int = sqlite3_key(db.value, key.ptr, key.size)
            result = rc != SQLITE_OK
        }
        return result
    }
}