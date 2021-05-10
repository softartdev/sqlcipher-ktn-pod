package com.softartdev.sqlcipherktnpod

import cnames.structs.sqlite3
import kotlinx.cinterop.*
import platform.Foundation.*
import sqlite3.*

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
            if (rc != SQLITE_OK) printError("Error opening database", db)
            val key = password?.cstr
            rc = sqlite3_key(db.value, key?.ptr, key?.size ?: 0)
            if (rc != SQLITE_OK) printError("Error key database", db)
            rc = sqlite3_exec(db.value, "SELECT count(*) FROM sqlite_master;", null, null, null)
            if (rc != SQLITE_OK) printError("Error executing database", db)
            result = rc == SQLITE_OK
            sqlite3_close(db.value)
        }
        return result
    }

    private fun getDatabasePath(dbName: String): String = dbDirPath.stringByAppendingPathComponent(dbName)

    private fun printError(title: String = "Error", db: CPointerVarOf<CPointer<sqlite3>>) {
        val errmsg = sqlite3_errmsg(db.value)
        println("$title: ${errmsg?.toKString()}")
    }
}