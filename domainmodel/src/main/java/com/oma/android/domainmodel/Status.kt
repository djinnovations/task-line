package com.oma.android.domainmodel

enum class Status(val text: String) {
    Todo("Todo"), InProgress("In Progress"), Blocked("Blocked"), Done("Done")
}

enum class BugStatus(val text: String) {
    RCA("Analysing"), InProgress("In Progress"), Invalid("Invalid"), Resolved("Resolved")
}