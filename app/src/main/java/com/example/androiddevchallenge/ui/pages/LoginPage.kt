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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.Images
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.components.SootheTextField
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

@Composable
fun LoginPage(navController: NavHostController) {
    Scaffold {
        LoginBackground()
        LoginBody(navController)
    }
}

@Composable
private fun LoginBackground() {
    Image(
        painter = Images.loginBackground(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
private fun LoginBody(navController: NavHostController) {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val signupPreamble = AnnotatedString(stringResource(R.string.login_signup_preamble) + " ")
    val signupLink = AnnotatedString(
        stringResource(R.string.login_signup_link),
        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline),
    )

    Column(
        Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {

        Text(
            stringResource(R.string.login_title).toUpperCase(Locale.getDefault()),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(bottom = 32.dp),
        )
        SootheTextField(
            value = email,
            onValueChange = setEmail,
            label = { Text(stringResource(R.string.login_email_label)) },
        )
        Spacer(Modifier.height(8.dp))
        SootheTextField(
            value = password,
            onValueChange = setPassword,
            label = { Text(stringResource(R.string.login_password_label)) },
        )
        Spacer(Modifier.height(8.dp))
        PrimaryButton(onClick = { navController.navigate("home") }) {
            Text(stringResource(R.string.login_action).toUpperCase(Locale.getDefault()))
        }
        Text(
            signupPreamble + signupLink,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

    }
}

@Preview
@Composable
fun LoginPreview() {
    MyTheme {
        LoginPage(rememberNavController())
    }
}
