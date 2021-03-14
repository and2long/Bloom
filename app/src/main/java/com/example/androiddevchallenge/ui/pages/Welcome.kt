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
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.green300
import com.example.androiddevchallenge.ui.theme.pink900
import com.example.androiddevchallenge.ui.theme.white
import com.example.androiddevchallenge.values.Destinations

@Composable
fun Welcome(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.fillMaxSize()) {
        val darkTheme = isSystemInDarkTheme()
        Image(
            painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_welcome_bg else R.drawable.ic_light_welcome_bg),
            contentDescription = null,
        )
        ConstraintLayout {
            val (logoImage, logoText, descText, btnRegister, btnLogin) = createRefs()
            Image(
                painter = painterResource(id = if (darkTheme) R.drawable.ic_dark_welcome_illos else R.drawable.ic_light_welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(logoImage) {
                        top.linkTo(parent.top, margin = 72.dp)
                        start.linkTo(parent.start, margin = 88.dp)
                    }
            )
            Image(
                painter = painterResource(if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo),
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
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .constrainAs(btnRegister) {
                        top.linkTo(descText.bottom, margin = 40.dp)
                    }
                    .height(48.dp)
                    .padding(start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = if (darkTheme) green300 else pink900)
            ) {
                Text(
                    text = "Create Account",
                    style = MaterialTheme.typography.button.copy(color = if (darkTheme) gray else white),
                )
            }
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

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview() {
    MyTheme {
        Welcome(navController = rememberNavController())
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview() {
    MyTheme(darkTheme = true) {
        Welcome(navController = rememberNavController())
    }
}
