package com.oma.android.viewtimesheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.oma.android.base.main.UiEvent
import com.oma.android.projecttask.data.TimesheetRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
internal class ViewTimesheetViewModel @Inject constructor(
    timesheetRepo: TimesheetRepo,
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    val timesheets = timesheetRepo.getTimesheetsPaged()
        .cachedIn(viewModelScope)
}