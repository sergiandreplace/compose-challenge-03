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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.Images
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.components.SecondaryButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomePage(navController: NavHostController) {
    Scaffold {
        WelcomeBackground()
        WelcomeBody(navController)
    }
}

@Composable
private fun WelcomeBackground() {
    Image(
        painter = Images.welcomeBackground(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun WelcomeBody(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)

    ) {
        Image(
            painter = Images.logo(),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton(onClick = { navController.navigate("login") }) { Text(stringResource(R.string.welcome_signup)) }
        Spacer(modifier = Modifier.height(8.dp))
        SecondaryButton(onClick = { navController.navigate("login") }) {
            Text(stringResource(R.string.welcome_login))
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomePage(rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomePage(rememberNavController())
    }
}
