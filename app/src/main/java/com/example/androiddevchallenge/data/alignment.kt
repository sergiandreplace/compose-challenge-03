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

data class AlignTopic(
    val title: String,
    @DrawableRes val image: Int
)

val bodyAlignments = listOf(
    AlignTopic("Inversions", R.drawable.inversions),
    AlignTopic("Quick yoga", R.drawable.quick_yoga),
    AlignTopic("Stretching", R.drawable.stretching),
    AlignTopic("Tabata", R.drawable.tabata),
    AlignTopic("HIIT", R.drawable.hiit),
    AlignTopic("Pre-natal yoga", R.drawable.prenatal_yoga),
)
val mindAlignments = listOf(
    AlignTopic("Meditate", R.drawable.meditate),
    AlignTopic("With kids", R.drawable.with_kids),
    AlignTopic("Aromatherapy", R.drawable.aromatherapy),
    AlignTopic("On the go", R.drawable.on_the_go),
    AlignTopic("With Pets", R.drawable.with_pets),
    AlignTopic("High stress", R.drawable.high_stress),
)
