package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape

@Composable
fun AppBackButton(
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFF181629),
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.size(
                    width = 10.dp,
                    height = 26.dp,),
            ) {
                Text(
                    text = "‹",
                    color = Color.White,
                    fontSize = 32.sp,
                    lineHeight = 32.sp,
                    modifier = Modifier.align(Alignment.Center).offset(y = (-8).dp),
                )

                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .align(Alignment.TopEnd)
                        .offset(
                            x = (1).dp,
                            y = 2.dp,
                        )
                        .background(
                            color = Color.White,
                            shape = CircleShape,
                        ),
                )
            }

            Spacer(
                modifier = Modifier.width(4.dp),
            )

            Text(
                text = "Назад",
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }
}