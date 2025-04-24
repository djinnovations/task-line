package com.oma.android.domainmodel.projectdetails

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectDataHolder @Inject constructor() {
    private var projectItem: ProjectItem? = null
    private var projectItemList: List<ProjectItem>? = null

    fun setCurrentProject(project: ProjectItem) {
        projectItem = project
    }

    fun getCurrentProject(): ProjectItem? = projectItem

    fun setProjectList(project: List<ProjectItem>) {
        projectItemList = project
    }

    fun getProjectList(): List<ProjectItem>? = projectItemList

    fun clear() {
        projectItem = null
    }
}