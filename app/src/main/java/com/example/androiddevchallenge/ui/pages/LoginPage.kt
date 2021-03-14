package com.example.androiddevchallenge.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.*

@Composable
fun LoginPage(navController: NavHostController) {
    val (email, setEmail) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val signupPreamble = AnnotatedString(stringResource(R.string.login_signup_preamble) + " ")
    val signupLink = AnnotatedString(
        stringResource(R.string.login_signup_link),
        spanStyle = SpanStyle(textDecoration = TextDecoration.Underline),
    )
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            Image(
                painter = painterResource(R.drawable.bkg_login),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            Box(Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
                Column(Modifier.align(Alignment.Center)) {
                    Text(
                        stringResource(R.string.login_title).toUpperCase(Locale.getDefault()),
                        style = MaterialTheme.typography.h1,
                        color = MaterialTheme.colors.onBackground,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .paddingFromBaseline(bottom = 32.dp),
                    )
                    TextField(
                        value = email,
                        onValueChange = setEmail,
                        label = { Text(stringResource(R.string.login_email_label)) },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    TextField(
                        value = password,
                        onValueChange = setPassword,
                        label = { Text(stringResource(R.string.login_password_label)) },
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
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
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    MyTheme {
        LoginPage(rememberNavController())
    }
}