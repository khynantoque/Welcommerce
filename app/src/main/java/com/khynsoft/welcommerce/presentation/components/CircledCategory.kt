package com.khynsoft.welcommerce.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.khynsoft.welcommerce.R

@Composable
fun CircledCategory(
    name: String,
    @DrawableRes icon: Int,
    isActive: Boolean = false,
    onClicked: () -> Unit
) {
    var active by remember {
        mutableStateOf(isActive)
    }
    Column() {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
        ) {
            IconButton(onClick = {
                active = !active
                onClicked()
            }) {
                Icon(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(100.dp),
                    painter = painterResource(id = icon),
                    contentDescription = "Category Icon",
                    tint = if (active) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.background
                )
            }
        }
        Text(text = name, style = MaterialTheme.typography.labelSmall, fontSize = 8.sp)
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 732)
@Composable
fun CirlcleCatergoryPreview() {
    CircledCategory("Hello", R.drawable.logo_hotel, onClicked = {}, isActive = false)
}