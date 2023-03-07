package com.example.dietpro.database

import com.example.dietpro.model.Meal
import com.example.dietpro.model.MealVO
import java.util.ArrayList

interface MealDao {
    fun listMeal(): ArrayList<MealVO>
    fun editMeal(_x: MealVO)
    fun createMeal(_x: MealVO)
    fun deleteMeal(_id: String)
    fun searchByMealid(idx: String): ArrayList<MealVO>
    fun searchByMealname(namex: String): ArrayList<MealVO>
    fun searchByMealcalories(caloriesx: String): ArrayList<MealVO>
    fun searchByMealdates(datex: String): ArrayList<MealVO>
    fun searchByMealimages(agex: String): ArrayList<MealVO>
    fun searchByMealanalysis(analysisx: String): ArrayList<MealVO>
    fun searchByMealuserName(userNamex: String): ArrayList<MealVO>
    fun addUsereatsMeal(userName: String, mealId: String)
    fun removeUsereatsMeal(userName: String, mealId: String)
}