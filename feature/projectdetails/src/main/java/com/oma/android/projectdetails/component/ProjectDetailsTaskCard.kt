package com.oma.android.projectdetails.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.theme.Themer
import com.oma.android.domainmodel.projectdetails.TaskItem

@Composable
fun ProjectDetailsTaskCard(task: TaskItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = task.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Themer.colors.TextAlternate
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Due date: ${task.getFormattedDueDate()}",
                    style = MaterialTheme.typography.labelMedium,
                    color = Themer.colors.TextAlternate
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${task.storyPoints} pts",
                    style = MaterialTheme.typography.labelMedium,
                    color = Themer.colors.TextAlternate
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                text = "Assigned to: ${task.assignedTo}",
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.End,
                color = Themer.colors.TextAlternate
            )
        }
    }
}