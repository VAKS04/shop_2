package com.example.shop

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import javax.xml.xpath.XPathFactory

class DBHelper(val context: Context, factory:
    SQLiteDatabase.CursorFactory?):SQLiteOpenHelper(context,"app",factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY,login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
    fun addUser(user:User){
        val value = ContentValues()
        value.put("login",user.login)
        value.put("email",user.email)
        value.put("pass",user.password)

        val db = this.writableDatabase
        db.insert("users",null, value)
        db.close()
    }
    fun getUser(login:String,password:String):Boolean{
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login ='$login' AND pass ='$password'" ,null)
        return result.moveToFirst()

    }

}