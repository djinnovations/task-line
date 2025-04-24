package com.oma.android.dashboard

import com.oma.android.domainmodel.projectdetails.ProjectItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeScreenData(
    val projectList: ImmutableList<ProjectItem> = persistentListOf()
)
