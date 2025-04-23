package com.oma.android.composeui.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.button.ButtonPrimary
import com.oma.android.composeui.theme.Themer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioGroupBottomSheet(
    title: String,
    presetStatus: String,
    options: Iterable<String>,
    onDismissRequest: () -> Unit,
    onStatusSelected: (String) -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        dragHandle = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(com.intuit.sdp.R.dimen._65sdp))
                    .drawBehind {
                        drawLine(
                            color = Color.Gray.copy(alpha = 0.7f),
                            start = Offset(0f, size.height - 8.dp.toPx()),
                            end = Offset(size.width, size.height - 8.dp.toPx()),
                            strokeWidth = 0.5.dp.toPx()
                        )
                    }
            ) {
                BottomSheetDefaults.DragHandle(
                    modifier = Modifier
                        .offset(y = (-2).dp)
                        .align(Alignment.TopCenter)
                )
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Themer.colors.TextAlternate
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            var selectedStatus by remember { mutableStateOf(presetStatus) }
            options.forEach { status ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                        .clickable { selectedStatus = status },
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = status,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    RadioButton(
                        selected = status == selectedStatus,
                        onClick = null
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp), text = "Done"
            ) {
                onStatusSelected(selectedStatus)
            }
            Spacer(Modifier.height(10.dp))
        }
    }
}