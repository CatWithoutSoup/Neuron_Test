package com.example.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.AppBackground
import com.example.ui.components.AppBackButton
import com.example.ui.components.AppTextField

@Composable
fun RegistrationScreen(
    state: RegistrationUiState,
    onParticipantNumberChanged: (String) -> Unit,
    onCodeChanged: (String) -> Unit,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onContinueClick: () -> Unit,
    onBack: () -> Unit,
) {
    var showLegalDialog by remember {
        mutableStateOf(false)
    }
    val scrollState = rememberScrollState()

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .imePadding()
                .verticalScroll(scrollState)
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 12.dp,
                    bottom = 20.dp,
                ),
        ) {

            AppBackButton(
                onClick = onBack,
            )

            Spacer(
                modifier = Modifier.height(40.dp),
            )

            Text(
                text = "Регистрация для\nклиентов банка",
                color = Color.White,
                fontSize = 34.sp,
                lineHeight = 42.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(
                modifier = Modifier.height(32.dp),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                AppTextField(
                    value = state.participantNumber,
                    onValueChange = onParticipantNumberChanged,
                    placeholder = "Номер участника",
                    helperText = "Номер из 16 цифр, который вы получили от банка",
                    keyboardType = KeyboardType.Number,
                    isError = state.isParticipantNumberError,
                )

                AppTextField(
                    value = state.code,
                    onValueChange = onCodeChanged,
                    placeholder = "Код",
                    helperText = "Код, который вы получили от банка",
                    keyboardType = KeyboardType.Number
                )

                AppTextField(
                    value = state.firstName,
                    onValueChange = onFirstNameChanged,
                    placeholder = "Имя",
                    helperText = "Имя (на латинице, как в загранпаспорте)",
                )

                AppTextField(
                    value = state.lastName,
                    onValueChange = onLastNameChanged,
                    placeholder = "Фамилия",
                    helperText = "Фамилия (на латинице, как в загранпаспорте)",
                )
            }

            Spacer(
                modifier = Modifier.weight(1f),
            )

            LegalAgreementText(
                onTermsClick = {
                    showLegalDialog = true
                },
            )

            Spacer(
                modifier = Modifier.height(20.dp),
            )

            Button(
                onClick = onContinueClick,
                enabled = state.isContinueEnabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC73250),
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFF8B3548),
                    disabledContentColor = Color(0xFFCAC3C8),
                ),
            ) {
                Text(
                    text = "Продолжить",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp),
            )
        }
    }

    if (showLegalDialog) {
        AlertDialog(
            onDismissRequest = {
                showLegalDialog = false
            },
            title = {
                Text("Условия участия")
            },
            text = {
                Text("Юридический текст...")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLegalDialog = false
                    },
                ) {
                    Text("Закрыть")
                }
            },
        )
    }
}

@Composable
private fun LegalAgreementText(
    onTermsClick: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Нажимая кнопку продолжить,",
            color = Color.White,
            fontSize = 14.sp,
        )

        Row {
            Text(
                text = "вы соглашаетесь ",
                color = Color.White,
                fontSize = 14.sp,
            )

            Text(
                text = "с условиями участия",
                modifier = Modifier.clickable(
                    onClick = onTermsClick,
                ),
                color = Color.White,
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
            )
        }
    }
}