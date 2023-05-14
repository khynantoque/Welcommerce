package com.khynsoft.welcommerce.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.khynsoft.welcommerce.R

val InriaSans = FontFamily(
    Font(R.font.inriasans_regular, FontWeight.Normal),
    Font(R.font.inriasans_bold, FontWeight.Bold),
    Font(R.font.inriasans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.inriasans_light, FontWeight.Light),
    Font(R.font.inriasans_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.inriasans_lightitalic, FontWeight.Light, FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = InriaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = InriaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = InriaSans,
        fontWeight = FontWeight.Light,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
)