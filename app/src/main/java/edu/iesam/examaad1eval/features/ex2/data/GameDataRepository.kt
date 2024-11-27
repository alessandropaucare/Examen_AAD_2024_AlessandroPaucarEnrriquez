package edu.iesam.examaad1eval.features.ex2.data

import edu.iesam.examaad1eval.features.ex2.Ex2Repository
import edu.iesam.examaad1eval.features.ex2.Game
import edu.iesam.examaad1eval.features.ex2.data.local.GamesBdLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource

class GameDataRepository(
    private val local: GamesBdLocalDataSource,
    private val remote: MockEx2RemoteDataSource
) : Ex2Repository {

    suspend override fun getGames(): Result<List<Game>> {
        try {
            val localGames = local.getAll()
            if (localGames.isEmpty()) {
                val remoteGames = remote.getGames()
                local.saveAll(remoteGames)
                return Result.success(remoteGames)
            } else {
                return Result.success(localGames)
            }
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

}