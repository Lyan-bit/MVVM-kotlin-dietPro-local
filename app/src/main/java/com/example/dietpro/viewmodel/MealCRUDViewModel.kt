package com.example.dietpro.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.dietpro.database.DataBaseManger
import com.example.dietpro.model.Meal
import com.example.dietpro.model.MealVO

class MealCRUDViewModel constructor(context: Context): ViewModel() {

    private var dbm: DataBaseManger = DataBaseManger (context)
    private var currentMeal: MealVO? = null
    private var currentMeals: ArrayList<MealVO> = ArrayList()

    companion object {
        private var instance: MealCRUDViewModel? = null
        fun getInstance(context: Context): MealCRUDViewModel {
            return instance ?: MealCRUDViewModel(context)
        }
    }

    fun stringListMeal(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (x in currentMeals.indices) {
            res.add(currentMeals[x].toString())
        }
        return res
    }

    fun getMeals(): ArrayList<Meal> {
        val res: List<MealVO> = dbm.listMeal()
        val vo: ArrayList<Meal> = ArrayList()
        for (meal in res) {
            val itemx = Meal.createByPKMeal(meal.mealId)
            itemx.mealId = meal.mealId
            itemx.mealName = meal.mealName
            itemx.userName = meal.userName
            itemx.dates = meal.dates
            itemx.calories = meal.calories
            itemx.analysis = meal.analysis
            itemx.images = meal.images
            itemx
            vo.add(itemx)
        }
        return vo
    }

    fun getMealByPK(value: String): Meal? {
        val res: List<MealVO> = dbm.searchByMealid(value)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: MealVO = res[0]
            val itemx = Meal.createByPKMeal(value)
            itemx.mealId = vo.mealId
            itemx.mealName = vo.mealName
            itemx.userName = vo.userName
            itemx.calories = vo.calories
            itemx.analysis = vo.analysis
            itemx.dates = vo.dates
            itemx.images = vo.images
            itemx
        }
    }

    fun retrieveMeal(value: String): Meal? {
        return getMealByPK(value)
    }

    fun allMealids(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].mealId)
        }
        return res
    }

    fun allMealnames(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].mealName)
        }
        return res
    }

    fun allMealdates(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].dates)
        }
        return res
    }

    fun allMealuserNames(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].userName)
        }
        return res
    }

    fun allMealcaloriess(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].calories.toString())
        }
        return res
    }

    fun allMealanalysiss(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].analysis)
        }
        return res
    }

    fun allMealimages(): ArrayList<String> {
        currentMeals = dbm.listMeal()
        val res: ArrayList<String> = ArrayList()
        for (meal in currentMeals.indices) {
            res.add(currentMeals[meal].images)
        }
        return res
    }

    fun setSelectedMeal(x: MealVO) {
        currentMeal = x
    }

    fun setSelectedMeal(i: Int) {
        if (i < currentMeals.size) {
            currentMeal = currentMeals[i]
        }
    }

    fun getSelectedMeal(): MealVO? {
        return currentMeal
    }

    fun persistMeal(x: Meal) {
        val vo = MealVO(x)
        dbm.editMeal(vo)
        currentMeal = vo
    }

    fun listMeal(): ArrayList<MealVO> {
        currentMeals = dbm.listMeal()
        return currentMeals
    }

    fun editMeal(x: MealVO) {
        dbm.editMeal(x)
        currentMeal = x
    }

    fun createMeal(x: MealVO) {
        dbm.createMeal(x)
        currentMeal = x
    }

    fun deleteMeal(id: String) {
        dbm.deleteMeal(id)
        currentMeal = null
    }

    fun searchByMealid(idx: String): List<MealVO> {
        currentMeals = dbm.searchByMealid(idx)
        return currentMeals
    }

    fun searchByMealname(namex: String): List<MealVO> {
        currentMeals = dbm.searchByMealname(namex)
        return currentMeals
    }

    fun searchByMealdates(datesx: String): List<MealVO> {
        currentMeals = dbm.searchByMealdates(datesx)
        return currentMeals
    }

    fun searchByMealcalories(caloriesx: String): List<MealVO> {
        currentMeals = dbm.searchByMealcalories(caloriesx)
        return currentMeals
    }

    fun searchByMealanalysis(analysisx: String): List<MealVO> {
        currentMeals = dbm.searchByMealanalysis(analysisx)
        return currentMeals
    }

    fun searchByMealimages(imagesx: String): List<MealVO> {
        currentMeals = dbm.searchByMealimages(imagesx)
        return currentMeals
    }

    fun searchByMealuserName(userNamex: String): List<MealVO> {
        currentMeals = dbm.searchByMealuserName(userNamex)
        return currentMeals
    }

    fun addUsereatsMeal(userName: String, mealId: String) {
        dbm.addUsereatsMeal(userName, mealId)
    }

    fun removeUsereatsMeal(userName: String, mealId: String) {
        dbm.removeUsereatsMeal(userName, mealId)
    }

}
