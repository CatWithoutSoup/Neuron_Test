package com.example.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val SettingsBackground = Color(0xFF242139)
private val HintText = Color(0xFFA8A4B5)

@Composable
fun SettingsRow(
    title: String,
    modifier: Modifier = Modifier,
    value: String? = null,
    showArrow: Boolean = true,
    onClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) {
                    Modifier.clickable(onClick = onClick)
                } else {
                    Modifier
                }
            ),
        shape = RoundedCornerShape(16.dp),
        color = SettingsBackground,
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 17.dp,
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                color = HintText,
                fontSize = 15.sp,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (value != null) {
                    Text(
                        text = value,
                        color = Color.White,
                        fontSize = 14.sp,
                    )
                }

                if (showArrow) {
                    Text(
                        text = "›",
                        color = Color.White,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(start = 8.dp),
                    )
                }
            }
        }
    }
}