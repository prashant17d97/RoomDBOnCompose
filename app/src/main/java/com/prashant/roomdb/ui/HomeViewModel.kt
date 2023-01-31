package com.prashant.roomdb.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.prashant.roomdb.db.UserRepo
import com.prashant.roomdb.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val employeeRepository: UserRepo) : ViewModel() {

    val employeeList: LiveData<List<User>> = employeeRepository.getAllUsers()

    fun foundEmployee(userId: String) = employeeRepository.findUser(userId)

    private fun getAllUsers() {
        employeeRepository.getAllUsers()
    }

    fun addEmployee(user: User) {
        employeeRepository.addUser(user)
        Log.e("TAG", "addEmployee: ${getAllUsers()}")
    }

    fun updateEmployeeDetails(user: User) {
        employeeRepository.updateUserDetails(user)
        getAllUsers()
    }

}