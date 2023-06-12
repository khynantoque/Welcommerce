package com.khynsoft.welcommerce.navigation

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.khynsoft.welcommerce.presentation.components.DisplayAlertDialog
import com.khynsoft.welcommerce.presentation.screens.auth.AuthenticationScreen
import com.khynsoft.welcommerce.presentation.screens.auth.AuthenticationViewModel
import com.khynsoft.welcommerce.presentation.screens.home.HomeScreen
import com.khynsoft.welcommerce.utils.Constants
import com.khynsoft.welcommerce.utils.Constants.APP_ID
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun SetupNavGraph(startDestination: String, navController: NavHostController) {
    NavHost(startDestination = startDestination, navController = navController) {
        authenticationRoute(
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screen.HomeScreen.route)
            }
        )
        homeRoute(
            navigateToAuth = {
                navController.popBackStack()
                navController.navigate(Screen.AuthenticationScreen.route)
            }
        )
        businessRoute()
    }
}

fun NavGraphBuilder.authenticationRoute(
    navigateToHome: () -> Unit
) {
    composable(route = Screen.AuthenticationScreen.route) {
        val viewModel: AuthenticationViewModel = viewModel()
        val authenticated by viewModel.authenticated
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        AuthenticationScreen(
            authenticated = authenticated,
            loadingState = oneTapState.opened,
            oneTapState = oneTapState,
            messageBarState = messageBarState,
            onButtonClicked = {
                oneTapState.open()
                viewModel.setLoadingState(true)
            },
            onTokenReceived = { tokenId ->
                viewModel.signInWithMongoAtlas(
                    tokenId,
                    onSuccess = {
                        messageBarState.addSuccess("Successfully Logged In!")
                        viewModel.setLoadingState(false)
                    },
                    onError = {
                        messageBarState.addError(it)
                    }
                )
            },
            onDialogDismissed = { message ->
                messageBarState.addError(Exception(message))
            },
            navigateToHome = navigateToHome
        )
    }
}

fun NavGraphBuilder.homeRoute(
    navigateToAuth: () -> Unit
) {
    composable(route = Screen.HomeScreen.route) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        var signOutDialogOpened by remember {
            mutableStateOf(false)
        }
        val scope = rememberCoroutineScope()

        HomeScreen(
            drawerState = drawerState,
            onMenuClicked = {
                scope.launch {
                    drawerState.open()
                }
            },
            onSignOutClicked = {
                signOutDialogOpened = true
            }
        )

        DisplayAlertDialog(
            title = "Sign Out",
            message = "Are you sure you want to log out from your Google account?",
            dialogOpened = signOutDialogOpened,
            onDialogClosed = { signOutDialogOpened = false },
            onYesClicked = {
                scope.launch {
                    val user = App.create(APP_ID).currentUser
                    if(user != null) {
                        user.logOut()
                        withContext(Dispatchers.Main) {
                            navigateToAuth()
                        }
                    }
                }
            }
        )
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