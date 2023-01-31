package com.prashant.roomdb.db

import androidx.lifecycle.MutableLiveData
import com.prashant.roomdb.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepo(private val userDao: UserDao) {

    private val allUser = MutableLiveData<List<User>>()

    private val foundUser = MutableLiveData<User>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addUser(newUser: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.addUser(newUser)
        }
    }

    fun updateUserDetails(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.updateUserDetails(user)
        }
    }

    fun findUser(userId: String): MutableLiveData<User> {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.findUserById(userId)
        }
        return foundUser
    }

    fun getAllUsers(): MutableLiveData<List<User>> {
        coroutineScope.launch(Dispatchers.IO) {
            allUser.value = userDao.getAllUsers()
        }
        return allUser
    }
}