package fi.groupd9.todoexampleapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import fi.groupd9.todoexampleapp.presenter.TodoPresenterImpl;

/**
 * Created by jjauhiainen on 07/09/16.
 */
public class TodoPresenterTest {

    private TodoViewMock tvm;
    private TodoPresenterImpl presenter;
    @Before
    public void setUp(){
        tvm = new TodoViewMock();
        presenter = new TodoPresenterImpl(tvm);
    }

    @Test
    public void addTodoWithNullShouldCallError() throws Exception{
        presenter.addTodo(null);
        assertTrue(tvm.isErrorCalled());
        assertFalse(tvm.isSuccesCalled());
    }

    @Test
    public void addTodoWithEmptyShouldCallError() throws Exception {
        presenter.addTodo("");
        assertTrue(tvm.isErrorCalled());
        assertFalse(tvm.isSuccesCalled());
    }

    @Test
    public void addTodoWithValidValueShouldCallSuccess() throws Exception {
        presenter.addTodo("my todo item");
        assertTrue(tvm.isSuccesCalled());
        assertFalse(tvm.isErrorCalled());
    }


}
