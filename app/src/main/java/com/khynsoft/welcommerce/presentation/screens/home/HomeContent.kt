package com.khynsoft.welcommerce.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khynsoft.welcommerce.R
import com.khynsoft.welcommerce.presentation.components.CircledCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    innerPaddingValues: PaddingValues
) {
    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        DockedSearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                active = false
            },
            placeholder = { Text(text = "Search business or item...") },
            active = active,
            onActiveChange = {
                active = it
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        if (text.isNotEmpty()) {
                            text = ""
                        } else {
                            active = false
                        }
                    },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon"
                )
            }
        ) { }

        Row(modifier = Modifier.fillMaxWidth()) {
            CircledCategory(name = "Hotel", icon = R.drawable.logo_hotel) {

            }
        }
    }


}