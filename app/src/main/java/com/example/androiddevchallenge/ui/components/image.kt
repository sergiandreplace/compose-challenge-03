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
