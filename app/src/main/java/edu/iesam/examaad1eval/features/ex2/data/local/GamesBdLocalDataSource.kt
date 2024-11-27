package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.Game


class GamesBdLocalDataSource(
    private val userDao: GamesDao
){
    suspend fun getAll(): List<Game>{
        return userDao.getAll()
    }
    suspend fun saveAll(games : List<Game>){
        userDao.insertAll(games)
    }

}

