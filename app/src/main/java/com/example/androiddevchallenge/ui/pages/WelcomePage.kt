package com.example.androiddevchallenge.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.components.SecondaryButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomePage(navController: NavHostController) {
    Surface(color = MaterialTheme.colors.background) {
        Image(
            painter = painterResource(R.drawable.bkg_welcome),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(alignment = Alignment.Center)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.img_logo),
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