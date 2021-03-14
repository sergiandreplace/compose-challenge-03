package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class FavoriteCollection(
    val title:String,
    @DrawableRes val image:Int
)

val favoriteCollections = listOf(
    FavoriteCollection("Short mantras", R.drawable.short_mantras),
    FavoriteCollection("Stress and anxiety", R.drawable.stress_and_anxiety),
    FavoriteCollection("Overwhelmed", R.drawable.overwhelmed),
    FavoriteCollection("Nature meditations", R.drawable.nature_meditations),
    FavoriteCollection("Self-massage", R.drawable.self_massage),
    FavoriteCollection("Nightly wind down", R.drawable.nightly_wind_down),
)