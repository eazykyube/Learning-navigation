# MAD_Assignment_1

Implementation of an assignment within the Mobile Application Development course in Innopolis University. Was done as a free-listener of the course.

## Assignment description

In the first assignment, your goal is to create an android application that will contain two types of navigation:

- Activity-based navigation
- Fragment-based navigation
The general logic of the application is next:

You should create a login screen with authorization and registration flows. 

Registration flow should contain at least 3 steps (on your choice ex: login, password, full name, age, address etc.) information sum up should be displayed on the last screen before click register:

- At every step, I should have an opportunity to go back and change my input.
- This part should be done by fragment-based navigation (check lecture slides about fragments)
- After registration, you should route to the login screen and login with entered during registration credentials (so you should store all data obtained during registration, in the retained fragment, or any other way. You may check shared preferences in advance https://developer.android.com/training/data-storage/shared-preferences.


Authorization should pass you on the application's main screen and show authorization credentials:

- After authorization, I shouldn't have an opportunity to go back to the login screen without using the logout option (you should add a logout button for going back to login screen)
- You should use credentials entered during the registration (not random one)


General requirements:

- You may use any of the instruments mentioned in lections (native navigation, cicerone or AAC Navigation component (check slides from moodle)
- Application design should support any type of screens (forget about hard coded width and height, check it in XML) 
- If I change screen orientation application should store all information that was entered (you should add on save instance state)
- All resources should be stored in res files.
