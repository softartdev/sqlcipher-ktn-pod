package com.softartdev.sqlcipherktnpod

import cnames.structs.sqlite3
import cocoapods.SQLCipher.*
import kotlinx.cinterop.*

fun checkCipherVersion(): String? {
    var result: String? = null
    memScoped {
        val db = allocPointerTo<sqlite3>()
        val stmt = allocPointerTo<sqlite3_stmt>()
        try {
            val password = "correct horse battery staple".cstr
            var rc: Int = sqlite3_open(":memory:", db.ptr)
            checkError(rc, db, "Error opening database")
            rc = sqlite3_key(db.value, password.ptr, password.size)
            checkError(rc, db, "Error setting key")
            rc = sqlite3_prepare_v2(db.value, "PRAGMA cipher_version;", -1, stmt.ptr, null)
            checkError(rc, db, "Error preparing SQL")
            rc = sqlite3_step(stmt.value)
            if (rc == SQLITE_ROW) {
                val uBytePointer: CPointer<UByteVar>? = sqlite3_column_text(stmt.value, 0)
                val verPointer: CPointer<ByteVar>? = uBytePointer?.reinterpret()
                result = verPointer?.toKString() ?: ""
            } else {
                checkError(rc, db, "Error retrieving cipher_version")
                throw RuntimeException("Error retrieving cipher_version, result code: $rc")
            }
        } finally {
            sqlite3_finalize(stmt.value)
            sqlite3_close(db.value)
        }
    }
    return result
}

private fun checkError(rc: Int, db: CPointerVarOf<CPointer<sqlite3>>, title: String) {
    if (rc == SQLITE_OK) return
    val errmsgCPointer: CPointer<ByteVar>? = sqlite3_errmsg(db.value)
    val message: String? = errmsgCPointer?.toKString()
    throw RuntimeException("$title: $message")
}
