package com.example.user.usecase

import com.example.user.model.User
import com.example.user.repository.UserRepository

class SaveUserUseCase(
    private val userRepository: UserRepository,
) {

    suspend operator fun invoke(user: User) {
        userRepository.saveUser(user)
    }
}