package com.oma.android.domainmodel.projectdetails

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class ProjectItem(
    val title: String,
    val description: String,
    val dueDate: Long,
    val taskItems: Iterable<TaskItem>
) {
    fun getFormattedDueDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(Date(dueDate))
    }
}