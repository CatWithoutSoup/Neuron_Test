package com.example.neuron_test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.profile.ProfileRoute
import com.example.purchases.PurchasesRoute
import com.example.registration.RegistrationRoute

@Composable
fun AppNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Profile.route,
    ) {
        composable(
            route = AppDestination.Profile.route,
        ) {
            ProfileRoute(
                onBack = {
                    navController.popBackStack()
                },
                onRegistrationClick = {
                    navController.navigate(
                        AppDestination.Registration.route
                    )
                },
                onPurchasesClick = {
                    navController.navigate(
                        AppDestination.Purchases.route
                    )
                },
            )
        }

        composable(
            route = AppDestination.Registration.route,
        ) {
            RegistrationRoute(
                onBack = {
                    navController.popBackStack()
                },
            )
        }
        composable(
            route = AppDestination.Purchases.route,
        ) {
            PurchasesRoute(
                onBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}