/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun MainPage() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = {
                val titles = mutableListOf("Home", "Favorites", "Profile", "Cart")
                val icons =
                    mutableListOf(
                        Icons.Default.Home,
                        Icons.Outlined.Favorite,
                        Icons.Default.AccountCircle,
                        Icons.Default.ShoppingCart
                    )
                BottomNavigation(backgroundColor = MaterialTheme.colors.primary) {
                    val curIndex = mutableStateOf(0)
                    for ((index, value) in titles.withIndex()) {
                        BottomNavigationItem(
                            icon = {
                                Image(
                                    imageVector = icons[index],
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(
                                        if (curIndex.value == index) MaterialTheme.colors.onBackground else Color(
                                            0xff757575
                                        )
                                    ),
                                )
                            },
                            label = { Text(text = value) },
                            onClick = {
                                curIndex.value = index
                            },
                            selected = index == curIndex.value,
                        )
                    }
                }
            },
            content = { HomePage() },
        )
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun MainPageLightPreview() {
    MyTheme {
        MainPage()
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 640)
fun MainPageDarkPreview() {
    MyTheme(darkTheme = true) {
        MainPage()
    }
}
