package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import edu.iesam.examaad1eval.core.ExamDataBase
import edu.iesam.examaad1eval.features.ex2.data.GameDataRepository
import edu.iesam.examaad1eval.features.ex2.data.local.GamesBdLocalDataSource
import edu.iesam.examaad1eval.features.ex2.data.remote.MockEx2RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1(){
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2(){

        GlobalScope.launch {
            val database = Room.databaseBuilder(
                applicationContext,
                ExamDataBase::class.java,
                getString(R.string.databaseName)
            ).build()

            val gamesDao = database.gamesDao()

            val localDataSource = GamesBdLocalDataSource(gamesDao)
            val remoteDataSource = MockEx2RemoteDataSource()
            val repository = GameDataRepository(localDataSource, remoteDataSource)


            val result = repository.getGames()

            result.fold(
                onSuccess = { games ->
                    Log.d("@dev","The following games were saved: $games")
                },
                onFailure = { exception ->
                    Log.d("@dev","Error in the fetching process: $exception")
                }
            )


        }
    }
}