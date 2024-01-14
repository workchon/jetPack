package com.example.jetpack.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpack.presentation.Dimension
import com.example.jetpack.presentation.common.NewTextButton
import com.example.jetpack.presentation.common.NewsButton
import com.example.jetpack.presentation.onboarding.component.OnBoardingPage
import com.example.jetpack.presentation.onboarding.component.PageIndicator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {
    Column(Modifier.fillMaxWidth()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])

        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimension.MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(Dimension.pageIndicatorWidth),
                pageSize = pages.size,
                selectPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()

                if (buttonState.value[0].isNotEmpty()) {
                    NewTextButton(text = buttonState.value[0], onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }
                    })
                }

                NewsButton(text = buttonState.value[1], onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 3) {
                            // TODO: Navigate to Home Screen
                        } else {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                })
            }
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}