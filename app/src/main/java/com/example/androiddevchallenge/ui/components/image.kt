package com.example.androiddevchallenge.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.androiddevchallenge.R

object Images {
    @Composable
    private fun painterDarkAware(@DrawableRes lightId: Int, @DrawableRes darkId: Int): Painter {
        val id = if (MaterialTheme.colors.isLight) lightId else darkId
        return painterResource(id)
    }

    @Composable
    fun welcomeBackground() =
        painterDarkAware(lightId = R.drawable.bkg_welcome, darkId = R.drawable.bkg_welcome_dark)

    @Composable
    fun loginBackground() =
        painterDarkAware(lightId = R.drawable.bkg_login, darkId = R.drawable.bkg_login_dark)

    @Composable
    fun logo() =
        painterDarkAware(lightId = R.drawable.img_logo, darkId = R.drawable.img_logo_dark)
}