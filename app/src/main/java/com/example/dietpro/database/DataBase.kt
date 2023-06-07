package com.example.dietpro.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.dietpro.model.MealVO

class DataBase  (context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASENAME, factory, DATABASEVERSION) {

    companion object{
        lateinit var database: SQLiteDatabase

        private val DATABASENAME = "dietproApp.db"
        private val DATABASEVERSION = 1

        const val MealTABLENAME = "Meal"
        const val MealCOLIDTable = 0
        const val MealCOLMEALID = 1
        const val MealCOLMEALNAME = 2
        const val MealCOLCALORIES = 3
        const val MealCOLDATES = 4
        const val MealCOLIMAGES = 5
        const val MealCOLANALYSIS = 6
        const val MealCOLUSERNAME = 7

        val MealCOLS: Array<String> = arrayOf<String>("idTable", "mealId", "mealName", "calories", "dates", "images", "analysis", "userName")
        const val MealNUMBERCOLS = 7

    }
    private val MealCREATESCHEMA =
        "create table Meal (idTable integer primary key autoincrement" +
                ", mealId VARCHAR(50) not null"+
                ", mealName VARCHAR(50) not null"+
                ", calories double not null"+
                ", dates VARCHAR(50) not null"+
                ", images VARCHAR(50) not null"+
                ", analysis VARCHAR(50) not null"+
                ", userName VARCHAR(50) not null"+
                ")"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(MealCREATESCHEMA)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + MealCREATESCHEMA)
        onCreate(db)
    }

    fun onDestroy() {
        database.close()
    }

    fun listMeal(): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val cursor: Cursor =
            database.query(MealTABLENAME, MealCOLS, null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun createMeal(mealvo: MealVO) {
        database = writableDatabase
        database.insert(MealTABLENAME, MealCOLS[1], putData(mealvo))
    }

    fun searchByMealmealId(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where mealId = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealmealName(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where mealName = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealcalories(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where calories = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealdates(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where dates = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealimages(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where images = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealanalysis(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where analysis = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchByMealuserName(value: String): ArrayList<MealVO> {
        val res = ArrayList<MealVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, mealId, mealName, calories, dates, images, analysis, userName from Meal where userName = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }


    fun editMeal(mealvo: MealVO) {
        database = writableDatabase
        val args = arrayOf(mealvo.getMealId())
        database.update(MealTABLENAME,  putData(mealvo), "mealId =?", args)
    }

    fun deleteMeal(value: String) {
        database = writableDatabase
        val args = arrayOf(value)
        database.delete(MealTABLENAME, "mealId = ?", args)
    }

    var mealId = "mealId = ?"
    fun addUsereatsMeal(userName: String, mealId: String) {
        database = writableDatabase
        val wr = ContentValues(1)
        wr.put(MealCOLS[(MealCOLUSERNAME], userName)
        val args = arrayOf(mealId)
        database.update(MealTABLENAME, wr, mealId, args)
    }
    fun removeUsereatsMeal(userName: String, mealId: String) {
        database = writableDatabase
        val wr = ContentValues(1)
        wr.put(MealCOLS[MealCOLUSERNAME], "NULL")
        val args = arrayOf(mealId)
        database.update(MealTABLENAME, wr, mealId, args)
    }

    private fun setData(cursor: Cursor): MealVO {
        val mealvo = MealVO()
        mealvo.setMealId(cursor.getString(MealCOLMEALID))
        mealvo.setMealName(cursor.getString(MealCOLMEALNAME))
        mealvo.setCalories(cursor.getDouble(MealCOLCALORIES))
        mealvo.setDates(cursor.getString(MealCOLDATES))
        mealvo.setImages(cursor.getString(MealCOLIMAGES))
        mealvo.setAnalysis(cursor.getString(MealCOLANALYSIS))
        mealvo.setUserName(cursor.getString(MealCOLUSERNAME))

        return mealvo
    }

    private fun putData(mealvo: MealVO): ContentValues {
        val wr = ContentValues(MealNUMBERCOLS)
        wr.put(MealCOLS[MealCOLMEALID], mealvo.getMealId())
        wr.put(MealCOLS[MealCOLMEALNAME], mealvo.getMealName())
        wr.put(MealCOLS[MealCOLCALORIES], mealvo.getCalories())
        wr.put(MealCOLS[MealCOLDATES], mealvo.getDates())
        wr.put(MealCOLS[MealCOLIMAGES], mealvo.getImages())
        wr.put(MealCOLS[MealCOLANALYSIS], mealvo.getAnalysis())
        wr.put(MealCOLS[MealCOLUSERNAME], mealvo.getUserName())
        return wr
    }
}
