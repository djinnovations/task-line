package com.oma.android.domainmodel.projectdetails

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectDataHolder @Inject constructor() {
    private var projectItem: ProjectItem? = null

    fun setCurrentProject(project: ProjectItem) {
        projectItem = project
    }

    fun getCurrentProject(): ProjectItem? = projectItem

    fun clear() {
        projectItem = null
    }
}