package com.oma.android.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oma.android.base.main.UiEvent
import com.oma.android.base.navigation.Destination
import com.oma.android.domainmodel.projectdetails.MockData
import com.oma.android.domainmodel.projectdetails.ProjectDataHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardSharedViewModel @Inject internal constructor(
    private val projectDataHolder: ProjectDataHolder
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    internal fun onEvent(event: DashboardEvent) {
        when (event) {
            DashboardEvent.ProjectItemClick -> {
                viewModelScope.launch {
                    projectDataHolder.setCurrentProject(MockData.getProjectData())
                    _uiEvent.emit(UiEvent.NavigateToActivity(Destination.ProjectDetails))
                }
            }
            DashboardEvent.TaskItemClick -> TODO()
        }
    }

}