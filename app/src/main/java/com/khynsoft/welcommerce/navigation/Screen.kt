package com.khynsoft.welcommerce.navigation

import com.khynsoft.welcommerce.utils.Constants.BUSINESS_ARGUMENT_KEY

sealed class Screen(val route: String) {
    object AuthenticationScreen: Screen(route = "authentication_screen")
    object HomeScreen: Screen(route = "home_screen")
    object BusinessScreen: Screen(route = "business_screen?$BUSINESS_ARGUMENT_KEY=${BUSINESS_ARGUMENT_KEY}") {
        fun passBusinessId(businessId: String) =
            "business_screen?$BUSINESS_ARGUMENT_KEY=$businessId"
    }
}
