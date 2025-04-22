package com.oma.android.projectdetails.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Secondary
import com.oma.android.domainmodel.Status
import com.oma.android.domainmodel.projectdetails.TaskItem
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TaskStatusColumn(
    status: Status,
    tasks: ImmutableList<TaskItem>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Secondary.copy(alpha = 0.5f), shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        // Status header
        Text(
            text = status.name.uppercase(),
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Tasks list
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tasks) { task ->
                ProjectDetailsTaskCard(task = task)
            }
        }
    }
}