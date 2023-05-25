# TaskMaster

## Overview

TaskMaster is an Android application that allows users to manage their tasks. Users can add then view and the status of tasks.

This application was developed using Java and XML in Android Studio.

## Setup

1. Clone this repository to your local machine.
2. Open the repository in Android Studio.
3. Run the app in the emulator.

## Features

### Homepage

The homepage of the application displays a list of current tasks. Each task item shows the task title, and icons representing the task's status. It also provides buttons to add new tasks and to navigate to the settings.

### Add a Task

Users can add a new task by clicking the "Add Task" button on the homepage. This will open a new page where users can type in the title and body of the new task. Clicking the "Save" button will add the task to the list and return the user to the homepage.

### Update Task Status

Users can update the status of a task to "doing" or "done" by clicking on the "Mark as Doing" or "Mark as Done" button respectively. This will update the status of the task and display the corresponding status icon (a rocket for "doing" and a check mark for "done").

### Settings

Users can navigate to the settings page by clicking on the settings icon on the top right corner of the homepage. Here, users can modify their username which will be displayed on the homepage.

## Changelog

### May 22, 2023

* Initial app setup
* Created homepage with task list and navigation buttons
* Added functionality to add tasks
* Prepared for future addition of "All Tasks" page

### May 23, 2023

* Added functionality to add and view task details
* Implemented Settings page where users can modify their username

### May 24, 2023

* Added functionality to mark tasks as "doing" or "done"
* Updated task list layout to accommodate status buttons and icons
* Added task status updates
* Removed task removal feature pending future update
* Added RecyclerView displays that swipe up and down along with being tappable
* Added ViewAdapter implementation

## Demo for Lab 28

### YouTube Link Lab 27

[![TaskMaster Lab27 Demo](/Users/camerongriffin/projects/courses/401/taskmaster/app/src/main/res/drawable/youtubeLogo.png)](https://youtu.be/voWokXM5zWI)

### YouTube Link Lab 28

[![TaskMaster Lab28 Demo](/Users/camerongriffin/projects/courses/401/taskmaster/app/src/main/res/drawable/youtubeLogo.png)](https://youtu.be/m6KUt6ONrR4)

## Future Work

* Implement persistent storage for tasks to maintain their statuses even when the app is closed
* Implement "All Tasks" page
* Add ability