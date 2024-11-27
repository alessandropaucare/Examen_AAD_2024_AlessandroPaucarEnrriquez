package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.iesam.examaad1eval.features.ex2.Player

class Converters {
        @TypeConverter
        fun fromPlayerList(players: List<Player>): String {
            val type = object : TypeToken<List<Player>>() {}.type
            return Gson().toJson(players, type)
        }

        @TypeConverter
        fun toPlayerList(playerString: String): List<Player> {
            val type = object : TypeToken<List<Player>>() {}.type
            return Gson().fromJson(playerString, type)
        }
}