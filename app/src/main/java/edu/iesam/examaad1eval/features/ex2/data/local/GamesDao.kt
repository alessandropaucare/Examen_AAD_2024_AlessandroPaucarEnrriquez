package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.iesam.examaad1eval.features.ex1.User
import edu.iesam.examaad1eval.features.ex2.Game

@Dao
interface GamesDao {
    @Query("SELECT * FROM games")
    fun getAll(): List<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg games: List<Game>)
}