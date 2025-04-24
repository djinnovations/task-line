package com.oma.android.dashboard.screen.uistatemodel

import com.oma.android.domainmodel.projectdetails.ProjectItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeScreenUiState(
    val projectList: ImmutableList<ProjectItem> = persistentListOf()
)
