package com.example.dietpro.database

import android.content.Context
import com.example.dietpro.model.MealVO
import java.util.ArrayList

class DataBaseManger constructor(context: Context) : MealDao {
    private var db: DataBase

    init {
        db = DataBase(context, null)
    }

    override fun listMeal(): ArrayList<MealVO> {
        return db.listMeal()
    }

    override fun editMeal(_x: MealVO) {
        db.editMeal(_x)
    }

    override fun createMeal(_x: MealVO) {
        db.createMeal(_x)
    }

    override fun deleteMeal(_id: String) {
        db.deleteMeal(_id)
    }

    override fun searchByMealid(idx: String): ArrayList<MealVO> {
        return db.searchByMealmealId(idx)
    }

    override fun searchByMealname(namex: String): ArrayList<MealVO> {
        return db.searchByMealmealName(namex)
    }

    override fun searchByMealimages(agex: String): ArrayList<MealVO> {
        return db.searchByMealimages(agex)
    }

    override fun searchByMealcalories(caloriesx: String): ArrayList<MealVO> {
        return db.searchByMealcalories(caloriesx)
    }

    override fun searchByMealdates(datex: String): ArrayList<MealVO> {
        return db.searchByMealdates(datex)
    }

    override fun searchByMealanalysis(analysisx: String): ArrayList<MealVO> {
        return db.searchByMealanalysis(analysisx)
    }

    override fun searchByMealuserName(userNamex: String): ArrayList<MealVO> {
        return db.searchByMealuserName(userNamex)
    }

    override fun addUsereatsMeal(userName: String, mealId: String) {
        return db.addUsereatsMeal(userName, mealId)
    }

    override fun removeUsereatsMeal(userName: String, mealId: String) {
        return db.removeUsereatsMeal(userName, mealId)
    }
}