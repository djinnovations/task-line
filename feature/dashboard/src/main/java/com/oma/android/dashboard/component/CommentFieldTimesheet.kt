package com.oma.android.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.oma.android.composeui.textinputfield.RoundedInputField
import com.oma.android.composeui.theme.Secondary

@Composable
fun CommentFieldTimesheet(modifier: Modifier, onCommentChanged: (String) -> Unit) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp)),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val description = remember { mutableStateOf("") }
            // Solid strip on top
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .background(Secondary)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )
            RoundedInputField(
                value = description.value,
                onValueChange = {
                    description.value = it
                    onCommentChanged(it)
                },
                placeholder = "Add Comments",
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                singleLine = false,
                minLines = 5
            )
        }
    }
}