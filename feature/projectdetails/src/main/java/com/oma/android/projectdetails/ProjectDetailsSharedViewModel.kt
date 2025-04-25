package com.oma.android.projectdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oma.android.base.main.UiEvent
import com.oma.android.domainmodel.projectdetails.ProjectDataHolder
import com.oma.android.domainmodel.projectdetails.TaskItem
import com.oma.android.domainmodel.projectdetails.toProject
import com.oma.android.domainmodel.projectdetails.toTaskDto
import com.oma.android.projectdetails.screen.uistatemodel.ProjectDetailsUiState
import com.oma.android.projecttask.data.ProjectTaskRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ProjectDetailsSharedViewModel @Inject constructor(
    private val projectTaskRepo: ProjectTaskRepo,
    private val projectDataHolder: ProjectDataHolder
) : ViewModel() {

    private val _projectWithTasksFlow = MutableStateFlow<ProjectDetailsUiState?>(null)
    val projectWithTasksFlow: StateFlow<ProjectDetailsUiState?> = _projectWithTasksFlow

    init {
        viewModelScope.launch {
            val projectId = getProjectData()?.id ?: return@launch
            projectTaskRepo
                .getProjectWithTaskFlow(projectId)
                .map { ProjectDetailsUiState(it.toProject()) }
                .collect { _projectWithTasksFlow.value = it }
        }
    }

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private var selectedTaskItem: TaskItem? = null

    fun onEvent(event: ProjectDetailsEvent) {
        when(event){
            is ProjectDetailsEvent.UpdateTaskItem -> updateTask(event.taskItem)
        }
    }

    fun getProjectData() = projectDataHolder.getCurrentProject()

    fun setTaskItem(taskItem: TaskItem) {
        selectedTaskItem = taskItem
    }

    fun getTaskItem() = selectedTaskItem

    fun clearSelectedTask() {
        selectedTaskItem = null
    }

    private fun updateTask(taskItem: TaskItem) {
        getProjectData()?.id?.also {
            viewModelScope.launch {
                projectTaskRepo.updateTask(taskItem.toTaskDto(it))
                _uiEvent.emit(UiEvent.NotifyMessage("Task Updated"))
            }
        }
    }
}