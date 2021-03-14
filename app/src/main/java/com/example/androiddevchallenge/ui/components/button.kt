package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    onClick: (() -> Unit),
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    BaseButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary,
        )
    ) { content() }
}

@Composable
fun SecondaryButton(
    onClick: (() -> Unit),
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    BaseButton(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = MaterialTheme.colors.onSecondary,
        )
    ) { content() }
}

@Composable
private fun BaseButton(
    onClick: (() -> Unit),
    colors: ButtonColors,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp),
        colors = colors,
    ) { content() }
}