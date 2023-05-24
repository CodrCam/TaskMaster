# TaskMaster

## Overview

TaskMaster is an Android application that allows users to manage their tasks. Users can add, view, and remove tasks from their list. Task details can also be viewed by clicking on a specific task from the list.

This application was developed using Java and XML in Android Studio.

## Setup

1. Clone this repository to your local machine.
2. Open the repository in Android Studio.
3. Run the app in the emulator.

## Features

### Homepage

The homepage of the application displays a list of current tasks. It also provides buttons to add new tasks and to view all tasks.

### Add a Task

Users can add a new task by clicking the "Add Task" button on the homepage. This will open a new page where users can type in the title and body of the new task. Clicking the "Submit" button will add the task to the list and return the user to the homepage.

### View Task Details

Users can view the details of a task by clicking on the task in the task list on the homepage. This will navigate to a new page displaying the title and body of the task.

### All Tasks

The "All Tasks" button on the homepage currently displays a placeholder message. In the future, this will be used to open a page displaying all tasks.

### Settings

Users can navigate to the settings page by clicking on the settings icon on the top right corner of the homepage. Here, users can modify their username which will be displayed on the homepage.

## Changelog

### May 22, 2023

* Initial app setup
* Created homepage with task list and navigation buttons
* Added functionality to add and remove tasks
* Prepared for future addition of "All Tasks" page

### May 23, 2023

* Added functionality to add and view task details
* Implemented Settings page where users can modify their username
* Removed "Remove Task" button from homepage. Task removal is planned to be moved to the task details page.


## Screenshots Lab 26

### App Home Screen

![HomeScreen](/app/images/appHome.png)

### ToDo Submit

![HomeScreen](/app/images/toDoSubmit.png)

### Full List for Tasks

![HomeScreen](/app/images/toDoFull.png)

### After Clicking 'Remove Task'

![HomeScreen](/app/images/toDoAfterDelete.png)

You can see it removed the most recently added task

### Couple All Tasks button is clickable

![AllTasks](/app/images/allTasks.png)

## Screenshots Lab 27

### User App Home Screen

![HomeScreen](/app/images/userNameHome.png)

Shows where the user name will go.

### Cam Setting's

![HomeScreen](/app/images/camSettings.png)

Enter user name

### User List for Tasks

![HomeScreen](/app/images/camHome.png)

Preloaded some tasks

### After Clicking on a Task

![TaskDetails](/app/images/taskDetails.png)

You can see the task details page with the task title and body

### Settings Page

![Settings](/app/images/camSettings.png)

Here you can modify your username

## Future Work

* Implement "All Tasks" page
* Add ability to remove tasks from task details page
* Add task due dates and reminders
* Add task categorization or tagging
