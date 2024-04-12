package com.example.myfitness.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemUser(users: Users)
    @Insert
    suspend fun insertItemFavorite(favorite: Favorite)
    @Insert
    suspend fun insertItemTrain(train: Train)

    @Query("SELECT * FROM Users WHERE login = :enteredLogin AND password = :enteredPassword")
    suspend fun getUserByLoginAndPassword(enteredLogin: String, enteredPassword: String): Users?
}