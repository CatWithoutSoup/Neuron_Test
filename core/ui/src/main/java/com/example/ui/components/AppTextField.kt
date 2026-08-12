package com.example.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FieldBackground = Color(0xFF242139)
private val FieldText = Color(0xFFF5F3FA)
private val HintText = Color(0xFFA8A4B5)
private val ErrorRed = Color(0xFFFF748A)

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    helperText: String,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    errorText: String = "Некорректные данные",
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    Column(
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            placeholder = {
                Text(
                    text = placeholder,
                    color = HintText,
                )
            },
            textStyle = TextStyle(
                color = if (isError) ErrorRed else FieldText,
            ),
            singleLine = true,
            isError = isError,
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = FieldBackground,
                unfocusedContainerColor = FieldBackground,
                errorContainerColor = FieldBackground,

                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                errorBorderColor = ErrorRed,

                cursorColor = Color.White,
                errorCursorColor = ErrorRed,
            ),
        )

        Text(
            text = if (isError) errorText else helperText,
            modifier = Modifier.padding(
                start = 2.dp,
                top = 5.dp,
            ),
            color = if (isError) ErrorRed else HintText,
            fontSize = if (isError) 14.sp else 11.sp,
        )
    }
}