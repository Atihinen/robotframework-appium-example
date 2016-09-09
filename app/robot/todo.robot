*** Settings ***
Library  AppiumLibrary  run_on_failure=Log Source
Suite Setup    Start Application
Suite Teardown  Close Application
*** Variables ***
${REMOTE_URL}      http://localhost:4723/wd/hub
${TODO_EDITTEXT}=    id=fi.groupd9.todoexampleapp:id/todoText
${ADD_TODO_BTN}=    id=fi.groupd9.todoexampleapp:id/addTodoBtn

*** Keywords ***
Start Application
    ${app_path}=    Set Variable    ${EXEC_DIR}/build/outputs/apk/app-debug.apk
    Open Application    ${REMOTE_URL}    platformVersion=4.4.2    platformName=Android    deviceName=06a0d860d0ee0c66    app=${app_path}    appPackage=fi.groupd9.todoexampleapp

*** Test Cases ***
Todo edittext should be visible
    Element Should Be Enabled    ${TODO_EDITTEXT}

Add todo button should be visible
    Element Should Be Enabled    ${ADD_TODO_BTN}

Adding Todo to todo list should show up
    Page Should Not Contain Text    tesmos
    Input Text    ${TODO_EDITTEXT}    tesmos
    Click Element    ${ADD_TODO_BTN}
    Page Should Contain Text    tesmos
