package com.example.shop

// Don't use
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbProduct(
    val context: Context,
    factory:SQLiteDatabase.CursorFactory?
):SQLiteOpenHelper(context,"app",factory,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE products (id INT PRIMARY KEY, title TEXT,image TEXT,full_description TEXT, mini_description TEXT,price TEXT)"
        db!!.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS products")
        onCreate(db)
    }
    fun addProduct(item:Item){
        val value = ContentValues()
        value.put("title",item.title)
        value.put("image",item.image)
        value.put("full_description",item.full_desc)
        value.put("mini_description",item.desc)
        value.put("price",item.price)
    }
    fun getAllProducts(
        title:String,
        image:String,
        desc:String,
        full_desc:String,
        price:String
    ) {
        val list = mutableListOf<Item>()
        val db = this.readableDatabase
        val cursor = db.query(
            "products",
            arrayOf(
                "title",
                "image",
                "full_description",
                "mini_description",
                "price",
            ),
            null, null, null, null, null
        )

        fun getProduct(
            title: String,
            image: String,
            desc: String,
            full_desc: String,
            price: String
        ): Boolean {
            val db = this.readableDatabase
            val result = db.rawQuery(
                "SELECT * FROM products WHERE title ='$title' AND image = '$image' AND full_description='$full_desc' AND mini_description = '$desc' AND price = '$price'",
                null
            )
            return result.moveToFirst()
        }

        fun work_with_cursor() {}
    }
}