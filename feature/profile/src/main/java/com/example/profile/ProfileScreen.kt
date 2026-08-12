package com.example.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.AppBackground
import com.example.ui.SettingsRow
import com.example.ui.components.AppBackButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.scale

private val HintText = Color(0xFFA8A4B5)

@Composable
fun ProfileScreen(
    state: ProfileUiState,
    onBack: () -> Unit,
    onRegistrationClick: () -> Unit,
    onPurchasesClick: () -> Unit = {},
) {
    var isBiometricsEnabled by remember {
        mutableStateOf(true)
    }
    val scrollState = rememberScrollState()

    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(scrollState)
                .padding(
                    horizontal = 22.dp,
                    vertical = 12.dp,
                ),
        ) {

            AppBackButton(
                onClick = onBack,
            )

            Spacer(
                modifier = Modifier.height(28.dp),
            )

            ProfileHeader(
                state = state,
            )

            Spacer(
                modifier = Modifier.height(28.dp),
            )

            SectionTitle(
                text = "МОИ ПОКУПКИ",
            )

            Spacer(
                modifier = Modifier.height(12.dp),
            )

            PurchasesRow(
                onClick = onPurchasesClick,
            )

            Spacer(
                modifier = Modifier.height(20.dp),
            )

            SectionTitle(
                text = "НАСТРОЙКИ",
            )

            Spacer(
                modifier = Modifier.height(12.dp),
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                EmailSettingsRow(
                    email = "kursantik341@gmail.com",
                )

                BiometricsSettingsRow(
                    checked = isBiometricsEnabled,
                    onCheckedChange = {
                        isBiometricsEnabled = it
                    },
                )

                SettingsRow(
                    title = "Сменить 4-х значный код",
                )

                SettingsRow(
                    title = "Регистрация для клиентов банка",
                    onClick = onRegistrationClick,
                )

                SettingsRow(
                    title = "Язык",
                    value = "русский",
                )
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    state: ProfileUiState,
) {
    val firstLine = if (state.hasUser) {
        state.lastName
    } else {
        "art"
    }

    val secondLine = if (state.hasUser) {
        state.firstName
    } else {
        "art"
    }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(
                    text = firstLine,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(
                    modifier = Modifier.height(16.dp),
                )

                Text(
                    text = secondLine,
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(
                modifier = Modifier.width(16.dp),
            )

            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Редактировать профиль",
                tint = Color(0xFFA9A5B4),
                modifier = Modifier
                    .size(24.dp)
                    .offset(y = 26.dp),
            )
        }

        Spacer(
            modifier = Modifier.height(20.dp),
        )

        Text(
            text = "+79243014334",
            color = Color(0xFFA9A5B4),
            fontSize = 16.sp,
        )
    }
}

@Composable
private fun SectionTitle(
    text: String,
) {
    Text(
        text = text,
        color = Color(0xFF8F8B9E),
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
    )
}

@Composable
private fun PurchasesRow(
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF242139),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 12.dp,
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.on_logo,
                ),
                contentDescription = "ON",
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
            )

            Text(
                text = "›",
                color = Color.White,
                fontSize = 24.sp,
            )
        }
    }
}

@Composable
private fun EmailSettingsRow(
    email: String,

) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF242139),

    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 18.dp,
                vertical = 14.dp,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "E-mail",
                color = HintText,
                fontSize = 15.sp,
            )

            Spacer(
                modifier = Modifier.weight(1f),
            )

            Column(
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = email,
                    color = Color.White,
                    fontSize = 13.sp,
                )

                Spacer(
                    modifier = Modifier.height(6.dp),
                )

                Text(
                    text = "Необходимо подтвердить",
                    color = Color(0xFFFF748A),
                    fontSize = 11.sp,

                )
            }

            Text(
                text = "›",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 6.dp)
                    .offset(y = (-11).dp),

            )
        }
    }
}

@Composable
private fun BiometricsSettingsRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFF242139),
    ) {
        Row(
            modifier = Modifier.padding(
                start = 18.dp,
                end = 12.dp,
                top = 8.dp,
                bottom = 8.dp,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Вход по биометрии",
                color = HintText,
                fontSize = 15.sp,
            )

            Spacer(
                modifier = Modifier.weight(1f),
            )

            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.scale(0.7f),
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    checkedTrackColor = Color(0xFFFF405C),

                    uncheckedThumbColor = Color(0xFFD1CED8),
                    uncheckedTrackColor = Color(0xFF5A566B),

                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent,
                ),
            )
        }
    }
}