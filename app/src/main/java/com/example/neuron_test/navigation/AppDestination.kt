package com.example.neuron_test.navigation

sealed class AppDestination(
    val route: String,
) {
    data object Profile : AppDestination("profile")
    data object Registration : AppDestination("registration")
    data object Purchases : AppDestination("purchases")
}