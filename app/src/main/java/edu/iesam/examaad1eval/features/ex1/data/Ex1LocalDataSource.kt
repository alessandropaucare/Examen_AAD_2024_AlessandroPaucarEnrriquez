package edu.iesam.examaad1eval.features.ex1.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.R
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User

class Ex1LocalDataSource(
    private val context: Context
) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.xml_file_name),
        Context.MODE_PRIVATE
    )
    private val gson = Gson()

    fun saveUserData(users: List<User>) {
        val usersJson = users.map { gson.toJson(it) }.toSet()
        sharedPreferences.edit().putStringSet("users", usersJson).apply()
    }

    fun saveItemData(items: List<Item>) {
        val itemJson = items.map { gson.toJson(it) }.toSet()
        sharedPreferences.edit().putStringSet("items", itemJson).apply()
    }
    fun saveServicesData(services: List<Services>) {
        val servicesJson = services.map { gson.toJson(it) }.toSet()
        sharedPreferences.edit().putStringSet("services", servicesJson).apply()
    }

    fun getUserData(): List<User> {
        val usersJson = sharedPreferences.getStringSet("users", emptySet()) ?: emptySet()
        val listType = object : TypeToken<List<User>>() {}.type
        return usersJson.map { gson.fromJson(it, listType) }
    }

    fun getItemData(): List<Item> {
        val itemJson = sharedPreferences.getStringSet("items", emptySet()) ?: emptySet()
        val listType = object : TypeToken<List<Item>>() {}.type
        return itemJson.map { gson.fromJson(it, listType) }
    }

    fun getServicesData(): List<Services> {
        val servicesJson = sharedPreferences.getStringSet("services", emptySet()) ?: emptySet()
        val listType = object : TypeToken<List<Services>>() {}.type
        return servicesJson.map { gson.fromJson(it, listType) }
    }



}
