package com.example.user.repository

import com.example.user.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {

    private val user = MutableStateFlow<User?>(null)

    override fun observeUser(): Flow<User?> {
        return user.asStateFlow()
    }

    override suspend fun saveUser(user: User) {
        this.user.value = user
    }
}