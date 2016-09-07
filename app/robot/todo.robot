*** Settings ***
Library  AppiumLibrary  run_on_failure=Log Source

*** Variables ***
${REMOTE_URL}  http://localhost:4723/wd/hub

*** Keywords ***
Start Application
    ${app_path}=    Evaluate    ${EXEC_DIR}+/app/build/outputs/apk/app-debug.apk
    Open Application    $\REMOTE_URL}    platformName=4.4.2
