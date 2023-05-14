package com.khynsoft.welcommerce.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.khynsoft.welcommerce.utils.Constants

@Composable
fun SetupNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(startDestination = startDestination, navController =  navController) {
        authenticationRoute(
            navigateToHome = {

            }
        )
        homeRoute()
        businessRoute()
    }
}

fun NavGraphBuilder.authenticationRoute(
    navigateToHome: () -> Unit
) {
    composable(route = Screen.AuthenticationScreen.route) {

    }
}

fun NavGraphBuilder.homeRoute(

) {
    composable(route = Screen.HomeScreen.route) {

    }
}

fun NavGraphBuilder.businessRoute(

) {
    composable(
        route = Screen.BusinessScreen.route,
        arguments = listOf(navArgument(name = Constants.BUSINESS_ARGUMENT_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {

    }
}