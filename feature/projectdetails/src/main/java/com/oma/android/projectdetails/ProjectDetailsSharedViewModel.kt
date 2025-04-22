package com.oma.android.projectdetails

import androidx.lifecycle.ViewModel
import com.oma.android.base.main.UiEvent
import com.oma.android.domainmodel.projectdetails.ProjectDataHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
internal class ProjectDetailsSharedViewModel @Inject constructor(
    private val projectDataHolder: ProjectDataHolder
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun getProjectData() = projectDataHolder.getCurrentProject()
}