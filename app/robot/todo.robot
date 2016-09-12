*** Settings ***
Library  AppiumLibrary  run_on_failure=Log Source
Suite Setup    Start Application
Suite Teardown  Close Application
*** Variables ***
${REMOTE_URL}      http://localhost:4723/wd/hub
${TODO_EDITTEXT}=    id=fi.groupd9.todoexampleapp:id/todoText
${ADD_TODO_BTN}=    id=fi.groupd9.todoexampleapp:id/addTodoBtn
${TODO_CONTENT}=    metropolia - introduction

*** Test Cases ***
Todo edittext should be visible
    Verify That Todo Edittext Is Visible

Add todo button should be visible
    Verify That Todo Add Button Is Visible

Adding Todo to todo list should show up
    Verify That Content Is Not Visible In Todo List    ${TODO_CONTENT}
    Add Todo Item    ${TODO_CONTENT}
    Submit Todo Form
    Verify That Content Is Visible In Todo List    ${TODO_CONTENT}


*** Keywords ***

Verify That Content Is Not Visible In Todo List
    [Arguments]    ${todo_content}
    Page Should Not Contain Text    ${todo_content}

Add Todo Item
    [Arguments]    ${todo_content}
    Input Text    ${TODO_EDITTEXT}    ${todo_content}

Submit Todo Form
    Click Element    ${ADD_TODO_BTN}

Verify That Content Is Visible In Todo List
    [Arguments]    ${todo_content}
    Page Should Contain Text    ${todo_content}

Verify That Todo Edittext Is Visible
    Element Should Be Enabled    ${TODO_EDITTEXT}

Verify That Todo Add Button Is Visible
    Element Should Be Enabled    ${ADD_TODO_BTN}



Start Application
    ${app_path}=    Set Variable    ${EXEC_DIR}/build/outputs/apk/app-debug.apk
    Open Application    ${REMOTE_URL}    platformVersion=${version}    platformName=Android    deviceName=${devicename}    app=${app_path}    appPackage=fi.groupd9.todoexampleapp
