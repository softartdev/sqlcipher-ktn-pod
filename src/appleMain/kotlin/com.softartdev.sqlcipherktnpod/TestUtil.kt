package com.softartdev.sqlcipherktnpod

import cnames.structs.sqlite3
import cocoapods.SQLCipher.*
import kotlinx.cinterop.*
import platform.Foundation.*

@Suppress("CAST_NEVER_SUCCEEDS")
class TestUtil {

    private val dbDirPath: NSString by lazy {
        val paths: List<*> = NSSearchPathForDirectoriesInDomains(
            directory = NSApplicationSupportDirectory,
            domainMask = NSUserDomainMask,
            expandTilde = true
        )
        val zeroPath: NSString = paths.first() as NSString
        return@lazy zeroPath.stringByAppendingPathComponent(str = "databases") as NSString
    }

    fun checkKey(password: String?, dbName: String): Boolean {
        var result = false
        memScoped {
            val dbPath = getDatabasePath(dbName)
            val db = allocPointerTo<sqlite3>()
            println("Try open db by path: $dbPath")
            var rc: Int = sqlite3_open(dbPath, db.ptr)
            if (isError(rc, "Error opening database", db)) return@memScoped
            val key = password?.cstr
            println("Try key: $key")
            rc = sqlite3_key(db.value, key?.ptr, key?.size ?: 0)
            if (isError(rc, "Error key database", db)) return@memScoped
            rc = sqlite3_exec(db.value, "SELECT count(*) FROM sqlite_master;", null, null, null)
            if (isError(rc, "Error executing database", db)) return@memScoped
            result = rc == SQLITE_OK
            sqlite3_close(db.value)
        }
        return result
    }

    private fun getDatabasePath(dbName: String): String = dbDirPath.stringByAppendingPathComponent(dbName)

    private fun isError(rc: Int, title: String, db: CPointerVarOf<CPointer<sqlite3>>): Boolean {
        if (rc == SQLITE_OK) return false
        val errmsg = sqlite3_errmsg(db.value)
        println("$title: ${errmsg?.toKString()}")
        return true
    }
}
