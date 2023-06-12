package com.khynsoft.welcommerce.presentation.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onMenuClicked: () -> Unit
) {
    CenterAlignedTopAppBar(
        navigationIcon = {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu Icon"
                )
            }
        },
        title = {
            Text(text = "Welcommerce")
        },
        actions = {
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = "Favorites",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
            IconButton(onClick = onMenuClicked) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Switch Account",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    )
}