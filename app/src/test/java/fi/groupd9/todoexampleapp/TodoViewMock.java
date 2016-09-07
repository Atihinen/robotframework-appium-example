package fi.groupd9.todoexampleapp;

import fi.groupd9.todoexampleapp.presenter.interfaces.TodoView;

/**
 * Created by jjauhiainen on 07/09/16.
 */
public class TodoViewMock implements TodoView {
    private boolean succesCalled;
    private boolean errorCalled;

    public void TodoViewMock(){
        succesCalled = false;
        errorCalled = false;
    }

    public boolean isErrorCalled() {
        return errorCalled;
    }

    public boolean isSuccesCalled() {
        return succesCalled;
    }

    @Override
    public void addSuccess(String content) {
        succesCalled = true;
    }

    @Override
    public void addError() {
        errorCalled = true;
    }
}
