package com.oma.android.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.dashboard.screen.uistatemodel.HomeScreenUiState
import com.oma.android.dashboard.screen.uistatemodel.TimesheetUiState
import com.oma.android.domainmodel.projectdetails.ProjectDataHolder
import com.oma.android.domainmodel.projectdetails.toProjectList
import com.oma.android.domainmodel.timesheet.TimesheetData
import com.oma.android.domainmodel.timesheet.toTimesheetDto
import com.oma.android.projecttask.data.ProjectTaskRepo
import com.oma.android.projecttask.data.TimesheetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardSharedViewModel @Inject internal constructor(
    private val projectTaskRepo: ProjectTaskRepo,
    private val timesheetRepo: TimesheetRepo,
    private val projectDataHolder: ProjectDataHolder
) : ViewModel() {

    private val _homeScreenStateFlow = MutableStateFlow(HomeScreenUiState())
    val homeScreenStateFlow = _homeScreenStateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            projectTaskRepo
                .getAllProjectsWithTask()
                .map {
                    val list = it.toProjectList().toPersistentList()
                    projectDataHolder.setProjectList(list)
                    HomeScreenUiState(it.toProjectList().toPersistentList())
                }
                .collect { _homeScreenStateFlow.value = it }
        }
    }

    private val _timesheetScreenStateFlow = MutableStateFlow(TimesheetUiState())
    val timesheetScreenStateFlow = _timesheetScreenStateFlow.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    internal fun onEvent(event: DashboardEvent) {
        when (event) {
            is DashboardEvent.ProjectItemClick -> {
                viewModelScope.launch {
                    projectDataHolder.setCurrentProject(event.project)
                    _uiEvent.emit(UiEvent.NavigateToActivity(Destination.ProjectDetails))
                }
            }
            is DashboardEvent.TaskItemClick -> TODO()
            is DashboardEvent.SubmitTimesheet -> {
                submitTimesheet(event.timesheetData)
            }
            DashboardEvent.FetchTimesheetOptions -> getTimesheetOptionsList()
            is DashboardEvent.NotifyMessage -> {
                viewModelScope.launch {
                    _uiEvent.emit(UiEvent.NotifyMessage(event.message))
                }
            }

            DashboardEvent.ViewTimeSheetClick -> {
                viewModelScope.launch {
                    _uiEvent.emit(UiEvent.NavigateToActivity(Destination.ViewTimesheet))
                }
            }
        }
    }

    private fun submitTimesheet(timesheetData: TimesheetData) {
        viewModelScope.launch {
            timesheetRepo.submitTimesheet(timesheetData.toTimesheetDto())
            _uiEvent.emit(UiEvent.NotifyMessage("Submission Successfully"))
        }
    }

    private fun getTimesheetOptionsList() {
        viewModelScope.launch(Dispatchers.Default) {
            val list = projectDataHolder.getProjectList()
            list?.associate { project ->
                project.title to project.taskItems.map { it.title }
            }?.also { map ->
                _timesheetScreenStateFlow.update {
                    it.copy(projectTitleMap = map)
                }
            }
        }
    }
}