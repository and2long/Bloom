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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.values.Destinations

@Composable
fun Welcome(navController: NavController, darkTheme: Boolean) {
    val bg = if (darkTheme) R.drawable.ic_dark_welcome_bg else R.drawable.ic_light_welcome_bg
    val illos =
        if (darkTheme) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos
    val logo = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = bg),
            contentDescription = null,
        )
        ConstraintLayout {
            val (logoImage, logoText, descText, btnRegister, btnLogin) = createRefs()
            Image(
                painter = painterResource(id = illos),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(logoImage) {
                        top.linkTo(parent.top, margin = 72.dp)
                        start.linkTo(parent.start, margin = 88.dp)
                    },
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = logo),
                contentDescription = null,
                modifier = Modifier.constrainAs(logoText) {
                    top.linkTo(logoImage.bottom, margin = 48.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Box(
                modifier = Modifier
                    .height(32.dp)
                    .fillMaxWidth()
                    .constrainAs(descText) {
                        top.linkTo(logoText.bottom)
                    }
            ) {
                Text(
                    text = "Beautiful home garden solutions",
                    style = MaterialTheme.typography.subtitle1.copy(color = MaterialTheme.colors.onPrimary),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            PrimaryButton(
                text = "Create Account", onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth()
                    .constrainAs(btnRegister) {
                        top.linkTo(descText.bottom, margin = 40.dp)
                    }
            )
            Text(
                text = "Log in",
                style = MaterialTheme.typography.button.copy(color = if (darkTheme) white else pink900),
                modifier = Modifier
                    .constrainAs(btnLogin) {
                        top.linkTo(btnRegister.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 24.dp)
                    .clickable(
                        onClick = {
                            navController.navigate(Destinations.Login)
                        }
                    )
            )
        }
    }
}

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    println(modifier)
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button.copy(color = MaterialTheme.colors.onSecondary),
        )
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview() {
    MyTheme {
        Welcome(navController = rememberNavController(), darkTheme = false)
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome(navController = rememberNavController(), darkTheme = true)
    }
}
