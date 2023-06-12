# TaskMaster

## Overview

TaskMaster is an Android application that allows users to manage their tasks. Users can add tasks, view tasks, and track the status of tasks. All task data is now persisted in a local database using Room.

This application was developed using Java and XML in Android Studio.

## Setup

1. Clone this repository to your local machine.
2. Open the repository in Android Studio.
3. Run the app in the emulator.

## Features

### Homepage

The homepage of the application displays a list of current tasks, persisted in a local database. Each task item shows the task title, and icons representing the task's status. It also provides buttons to add new tasks and to navigate to the settings.

### Add a Task

Users can add a new task by clicking the "Add Task" button on the homepage. This will open a new page where users can type in the title and body of the new task. Clicking the "Save" button will add the task to the list and the database, then return the user to the homepage.

### Update Task Status

Users can update the status of a task to "doing" or "done" by clicking on the "Mark as Doing" or "Mark as Done" button respectively. This will update the status of the task in the database and display the corresponding status icon (a rocket for "doing" and a check mark for "done").

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

### May 25, 2023

* Integrated Room database to persist task data
* Updated the "Add Task" functionality to save tasks to the database
* Refactored the task list to load tasks from the database
* Ensured task status updates are reflected in the database

### Jun 12, 2023

* Made small hot fixes
* Added to Google Play Store

## Demos

### YouTube Link Lab 27

<a href="https://youtu.be/voWokXM5zWI">
    <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Youtube_colored_svg-512.png" alt="TaskMaster Lab27 Demo" width="100" height="100" />
</a>

### YouTube Link Lab 28

<a href="https://youtu.be/m6KUt6ONrR4">
    <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Youtube_colored_svg-512.png" alt="TaskMaster Lab28 Demo" width="100" height="100" />
</a>

### YouTube Link Lab 29

<a href="https://youtu.be/GJE5YIJe9XM">
    <img src="https://cdn2.iconfinder.com/data/icons/social-media-2285/512/1_Youtube_colored_svg-512.png" alt="TaskMaster Lab29 Demo" width="100" height="100" />
</a>


## Future Work

* Implement "All Tasks" page
* Add ability to remove tasks from task details page
* Add task due dates and reminders
* Add task categorization or tagging
