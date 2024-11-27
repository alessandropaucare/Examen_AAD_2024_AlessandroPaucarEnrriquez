package edu.iesam.examaad1eval.features.ex2

interface Ex2Repository {
    suspend fun getGames(): Result<List<Game>>
}