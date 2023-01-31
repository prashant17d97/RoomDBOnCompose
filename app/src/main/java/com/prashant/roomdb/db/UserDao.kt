package com.prashant.roomdb.db

import androidx.room.*
import com.prashant.roomdb.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM users WHERE userId = :userId")
    fun findUserById(userId: String): User

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Update
    suspend fun updateUserDetails(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}