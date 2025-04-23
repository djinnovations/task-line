package com.oma.android.domainmodel.projectdetails

import android.os.Parcelable
import com.oma.android.domainmodel.Status
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Parcelize
data class TaskItem(
    val title: String,
    val description: String,
    val dueDate: Long,
    val storyPoints: Int,
    val assignedTo: String,
    val status: Status = Status.Todo
) : Parcelable {
    fun getFormattedDueDate(): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(Date(dueDate))
    }
}