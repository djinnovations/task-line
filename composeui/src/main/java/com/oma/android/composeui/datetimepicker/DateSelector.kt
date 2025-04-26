package com.oma.android.composeui.datetimepicker

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun DateSelector(
    modifier: Modifier,
    hint: String,
    initialDate: Calendar = Calendar.getInstance(),
    onDateSelected: (formattedDate: String, epochMillis: Long) -> Unit
) {
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    // Date Field (opens modal)
    var formattedDate by remember {
        mutableStateOf(dateFormat.format(initialDate.time))
    }
    val context = LocalContext.current
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val cal = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, month)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth)
                }
                formattedDate = dateFormat.format(cal.time)
                onDateSelected(formattedDate, cal.timeInMillis)
            },
            initialDate.get(Calendar.YEAR),
            initialDate.get(Calendar.MONTH),
            initialDate.get(Calendar.DAY_OF_MONTH)
        )
    }

    Row(modifier = modifier
        .clickable {
            datePickerDialog.show()
        },
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.CalendarMonth,
            contentDescription = "Due Date",
            tint = Themer.colors.Black100
        )
        Text(
            hint, style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Text(
            formattedDate,
            style = MaterialTheme.typography.labelMedium,
            color = Themer.colors.TextAlternate
        )
        Spacer(Modifier.weight(1f, true))
        Icon(
            Icons.AutoMirrored.Default.ArrowRight, contentDescription = "Arrow",
            tint = Themer.colors.Black100
        )
    }
    // Set date on first run
    LaunchedEffect(Unit) {
        onDateSelected(formattedDate, initialDate.timeInMillis)
    }
}