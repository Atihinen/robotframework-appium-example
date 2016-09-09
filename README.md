# Robotframework appium library
Running test cases with appium against android application

# Requirements

* Android device with developer access
* npm & nodejs
* Android sdk
* Oracle Java 8
* Python 2.7.x
* pip

# App description

Simple listview app that has edittext and button to add todo items
Items cannot be deleted atm.

# Setup

* Install appium server `npm install`
* Install robotframework and appiumlibrary `pip install -r requirements.txt`

# Run tests

1 Build the application `./gradlew assemble`
2 Check your device name `adb devices`
3 cd to app
4 Run `robot --variable deivicename:<your_device> --variable version:<your_android_version> robot/todo.robot`
