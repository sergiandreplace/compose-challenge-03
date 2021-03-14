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
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class FavoriteCollection(
    val title: String,
    @DrawableRes val image: Int
)

val favoriteCollections = listOf(
    FavoriteCollection("Short mantras", R.drawable.short_mantras),
    FavoriteCollection("Stress and anxiety", R.drawable.stress_and_anxiety),
    FavoriteCollection("Overwhelmed", R.drawable.overwhelmed),
    FavoriteCollection("Nature meditations", R.drawable.nature_meditations),
    FavoriteCollection("Self-massage", R.drawable.self_massage),
    FavoriteCollection("Nightly wind down", R.drawable.nightly_wind_down),
)
