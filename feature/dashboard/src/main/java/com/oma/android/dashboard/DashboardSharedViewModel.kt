package com.oma.android.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.domainmodel.projectdetails.ProjectDataHolder
import com.oma.android.domainmodel.projectdetails.toProjectList
import com.oma.android.projecttask.data.ProjectTaskRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardSharedViewModel @Inject internal constructor(
    private val projectTaskRepo: ProjectTaskRepo,
    private val projectDataHolder: ProjectDataHolder
) : ViewModel() {

    private val _homeScreenStateFlow = MutableStateFlow(HomeScreenData())
    val homeScreenStateFlow = _homeScreenStateFlow.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    internal fun onEvent(event: DashboardEvent) {
        when (event) {
            DashboardEvent.FetchProjects -> getProjectList()
            is DashboardEvent.ProjectItemClick -> {
                viewModelScope.launch {
                    projectDataHolder.setCurrentProject(event.project)
                    _uiEvent.emit(UiEvent.NavigateToActivity(Destination.ProjectDetails))
                }
            }
            is DashboardEvent.TaskItemClick -> TODO()
        }
    }

    private fun getProjectList() {
        viewModelScope.launch {
            val projects = projectTaskRepo.getAllProjectsWithTask().toProjectList()
            _homeScreenStateFlow.update {
                it.copy(projectList = projects.toPersistentList())
            }
        }
    }

}