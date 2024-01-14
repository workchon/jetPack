package com.example.jetpack.presentation.onboarding

import androidx.annotation.DrawableRes
// importacion de recursos
import com.example.jetpack.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Lorem ipsum dolor sit amet",
        description = "Lectus sit amet est placerat in.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Lorem ipsum dolor sit amet",
        description = "Lectus sit amet est placerat in.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Lorem ipsum dolor sit amet",
        description = "Lectus sit amet est placerat in.",
        image = R.drawable.onboarding3
    )
)