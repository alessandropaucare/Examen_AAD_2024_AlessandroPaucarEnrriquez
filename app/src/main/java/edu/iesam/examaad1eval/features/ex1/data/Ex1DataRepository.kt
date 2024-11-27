package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.Item
import edu.iesam.examaad1eval.features.ex1.Services
import edu.iesam.examaad1eval.features.ex1.User

class Ex1DataRepository(
    private val remote: MockEx1RemoteDataSource,
    private val local: Ex1LocalDataSource,
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val localUsers = local.getUserData()

        if(localUsers.isEmpty()){
            val remoteUsers = remote.getUsers()
            local.saveUserData(remoteUsers)
            return remoteUsers
        }

        return localUsers
    }

    override fun getItems(): List<Item> {
        val localItems = local.getItemData()

        if(localItems.isEmpty()){
            val remoteItems = remote.getItems()
            local.saveItemData(remoteItems)
            return remoteItems
        }

        return localItems
    }

    override fun getServices(): List<Services> {
        val localServices = local.getServicesData()

        if(localServices.isEmpty()){
            val remoteServices = remote.getServices()
            local.saveServicesData(remoteServices)
            return remoteServices
        }

        return localServices
    }
}
