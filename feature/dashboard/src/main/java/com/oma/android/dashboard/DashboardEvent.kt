package com.oma.android.dashboard

internal sealed class DashboardEvent {

    data object ProjectItemClick: DashboardEvent()
    data object TaskItemClick: DashboardEvent()
}