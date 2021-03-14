package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class AlignTopic(
    val title:String,
    @DrawableRes val image:Int
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
