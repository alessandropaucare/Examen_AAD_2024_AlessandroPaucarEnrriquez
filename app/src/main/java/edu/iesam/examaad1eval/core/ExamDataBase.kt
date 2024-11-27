package edu.iesam.examaad1eval.core

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.examaad1eval.features.ex2.data.local.GameEntity
import edu.iesam.examaad1eval.features.ex2.data.local.GamesDao

@Database(entities = [GameEntity::class], version = 1)
abstract class ExamDataBase : RoomDatabase() {
        abstract fun gamesDao() : GamesDao
}

