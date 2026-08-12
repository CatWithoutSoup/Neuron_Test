package com.example.user.repository

import com.example.user.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun observeUser(): Flow<User?>

    suspend fun saveUser(user: User)
}