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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

private val kulimPark = FontFamily(
    Font(R.font.kulimpark_light, FontWeight.Light),
    Font(R.font.kulimpark_regular, FontWeight.Normal)
)

private val lato = FontFamily(
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val typography = Typography(
    h1 = TextStyle(
        fontFamily = kulimPark,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        letterSpacing = 1.15.sp
    ),
    h2 = TextStyle(
        fontFamily = kulimPark,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = 1.15.sp,
    ),
    h3 = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontFamily = lato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
        fontFeatureSettings = "smcp"

    ),
    caption = TextStyle(
        fontFamily = kulimPark,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 1.15.sp
    ),
)

@Composable
@Preview
fun Caps() {
    MyTheme {
        Surface {
            Column {
                Text("H1 / Kulim Park Light", style = MaterialTheme.typography.h1)
                Text("H2 / Kulim Park Regular", style = MaterialTheme.typography.h2)
                Text("H3 / Lato Bold", style = MaterialTheme.typography.h3)
                Text("Body1 / Lato Regular", style = MaterialTheme.typography.body1)
                Text("Button / Lato Bold", style = MaterialTheme.typography.button)
                Text("Caption / Kulim Park Regular", style = MaterialTheme.typography.caption)
            }
        }
    }
}
