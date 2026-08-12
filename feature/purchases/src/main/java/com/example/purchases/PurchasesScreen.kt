package com.example.purchases

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.AppBackground
import com.example.ui.components.AppBackButton

@Composable
fun PurchasesScreen(
    state: PurchasesUiState,
    onBack: () -> Unit,
) {
    AppBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .padding(
                    horizontal = 22.dp,
                    vertical = 12.dp,
                ),
        ) {
            AppBackButton(
                onClick = onBack,
            )

            Text(
                text = "Мои покупки",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 32.dp,
                    bottom = 24.dp,
                ),
            )

            if (state.isLoading) {
                CircularProgressIndicator()
            } else {
                PurchasesList(
                    groups = state.groups,
                )
            }
        }
    }
}

@Composable
private fun PurchasesList(
    groups: List<PurchaseGroupUi>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        items(
            items = groups,
            key = { it.date },
        ) { group ->

            PurchaseGroupItem(
                group = group,
            )
        }
    }
}

@Composable
private fun PurchaseGroupItem(
    group: PurchaseGroupUi,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = group.date,
            color = Color(0xFFA9A5B4),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )

        group.names.forEach { name ->
            Text(
                text = name,
                color = Color.White,
                fontSize = 18.sp,
            )
        }
    }
}