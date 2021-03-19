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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.components.ItemGarden
import com.example.androiddevchallenge.ui.components.SearchBar
import com.example.androiddevchallenge.ui.components.ThemeCard
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomePage() {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            SearchBar()
            Text(
                text = "Browse themes",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(16.dp)
            )
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(start = 16.dp)
            ) {
                items(20) {
                    ThemeCard()
                }
            }
            Box(
                modifier = Modifier
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .align(Alignment.BottomStart)
                )
                Image(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground)
                )
            }
            val titles = mutableListOf("Monstera", "Aglaonema", "Peace lity", "Fiddle leaf tree")
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(20) {
                    ItemGarden(
                        it == 0,
                        titles[it % 4]
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme(darkTheme = false) {
        HomePage()
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomePage()
    }
}
