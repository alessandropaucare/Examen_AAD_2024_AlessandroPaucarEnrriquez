package edu.iesam.examaad1eval

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.examaad1eval.features.ex1.data.Ex1DataRepository
import edu.iesam.examaad1eval.features.ex1.data.Ex1LocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.MockEx1RemoteDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var localDataSource: Ex1LocalDataSource
    private lateinit var remoteDataSource: MockEx1RemoteDataSource
    private lateinit var dataRepository: Ex1DataRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        executeExercise1()
        executeExercise2()
    }

    private fun executeExercise1() {

        localDataSource = Ex1LocalDataSource(this)
        remoteDataSource = MockEx1RemoteDataSource()
        dataRepository = Ex1DataRepository(remoteDataSource, localDataSource)

        val userList = dataRepository.getUsers()
        Log.d("@dev", "GamesList:")
        Log.d("@dev", "$userList")
        val itemList = dataRepository.getItems()
        Log.d("@dev", "ItemsList:")
        Log.d("@dev", "$itemList")
        val serviceList = dataRepository.getServices()
        Log.d("@dev", "ServicesList")
        Log.d("@dev", "$serviceList")

    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun executeExercise2() {
        //Ejecutar el ejercicio 2 desde aquí llamando al Ex2DataRepository directamente
        GlobalScope.launch {
            //llamar a Room
        }
    }
}