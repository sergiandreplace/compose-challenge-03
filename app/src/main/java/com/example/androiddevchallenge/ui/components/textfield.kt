package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SootheTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    ) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}