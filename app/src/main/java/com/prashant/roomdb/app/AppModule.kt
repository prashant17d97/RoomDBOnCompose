package com.prashant.roomdb.app

import android.content.Context
import androidx.room.Room
import com.prashant.roomdb.db.UserDao
import com.prashant.roomdb.db.UserRepo
import com.prashant.roomdb.db.UserRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, UserRoomDatabase::class.java, "employee_database")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideUserRepo(@ApplicationContext context: Context) =
        UserRepo(provideDB(context).userDao())
}