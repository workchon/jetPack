package com.example.jetpack.presentation.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.jetpack.presentation.Dimension

@Composable
fun PageIndicator(
    modifier: Modifier,
    pageSize: Int,
    selectPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.tertiaryContainer,
    unselectedColor: Color = MaterialTheme.colorScheme.onTertiaryContainer
) {
    Row(modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(Dimension.indicatorSize)
                    .clip(CircleShape)
                    .background(color = if (page == selectPage) selectedColor else unselectedColor)
            )
        }
    }
}