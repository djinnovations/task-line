package com.oma.android.dashboard.component

import android.app.TimePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer

@Composable
fun TimeSelector(
    modifier: Modifier,
    label: String = "Select Time",
    initialTime: Pair<Int, Int>,
    onTimeSelected: (Pair<Int, Int>) -> Unit
) {
    var selectedTime by remember { mutableStateOf(initialTime) }
    val context = LocalContext.current

    val timePickerDialog = remember {
        TimePickerDialog(
            context,
            { _, hour, minute ->
                selectedTime = hour to minute
                onTimeSelected(selectedTime)
            },
            selectedTime.first,
            selectedTime.second,
            true // 24-hour format
        )
    }

    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.Dugong
        )
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .clickable {
                    timePickerDialog.show()
                }
                .background(color = Themer.colors.FillSecondary)
                .padding(horizontal = 10.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "${selectedTime.first}:${selectedTime.second}",
                style = MaterialTheme.typography.labelLarge,
                color = Themer.colors.TextAlternate
            )
        }
    }
}