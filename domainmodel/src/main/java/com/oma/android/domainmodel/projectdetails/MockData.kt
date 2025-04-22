package com.oma.android.domainmodel.projectdetails

import com.oma.android.domainmodel.Status

object MockData {

    fun getProjectData() = ProjectItem(
        title = "Tiki Mobile app project",
        description = "Ui kit design project for task, notes and reminder",
        dueDate = 1746302128000,
        taskItems = getTaskItem()
    )

    private fun getTaskItem() : List<TaskItem>{
        val list = mutableListOf<TaskItem>()
        list.add(
            TaskItem(
                "BrainStrom",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745438128000,
                storyPoints = 3,
                assignedTo = "Darshan",
                status = Status.Todo
            )
        )
        list.add(
            TaskItem(
                "Build Wireframe",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745524528000,
                storyPoints = 5,
                assignedTo = "Darshan-clone",
                status = Status.Todo
            )
        )
        list.add(
            TaskItem(
                "Create Design guideline",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745610928000,
                storyPoints = 2,
                assignedTo = "Darshan-clone",
                status = Status.InProgress
            )
        )
        list.add(
            TaskItem(
                "Create Workflow",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745438128000,
                storyPoints = 2,
                assignedTo = "Darshan",
                status = Status.InProgress
            )
        )
        list.add(
            TaskItem(
                "Kickoff meeting",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745265328000,
                storyPoints = 2,
                assignedTo = "Darshan",
                status = Status.Done
            )
        )
        list.add(
            TaskItem(
                "Create insta content",
                "Lorem ipsum, or lipsum as it is sometimes known, " +
                        "is dummy text used in laying out print",
                dueDate = 1745178928000,
                storyPoints = 2,
                assignedTo = "Darshan-clone",
                status = Status.Done
            )
        )
        return list
    }
}