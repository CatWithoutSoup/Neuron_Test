package com.example.user.usecase

import com.example.user.model.User
import com.example.user.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveUserUseCase(
    private val userRepository: UserRepository,
) {

    operator fun invoke(): Flow<User?> {
        return userRepository.observeUser()
    }
}