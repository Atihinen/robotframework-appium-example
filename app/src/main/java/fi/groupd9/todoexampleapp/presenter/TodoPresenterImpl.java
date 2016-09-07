package fi.groupd9.todoexampleapp.presenter;

import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

import fi.groupd9.todoexampleapp.presenter.interfaces.TodoPresenter;
import fi.groupd9.todoexampleapp.presenter.interfaces.TodoView;

/**
 * Created by con_jjauhiai on 7.9.2016.
 */
public class TodoPresenterImpl implements TodoPresenter {
    private TodoView todoView;
    public TodoPresenterImpl(TodoView todoView){this.todoView = todoView;}
    @Override
    public void addTodo(String todoTxt) {
        Log.d("**************** ", todoTxt);
        if(todoTxt.isEmpty()){
            todoView.addError();
        }
        else {
            todoView.addSuccess(todoTxt);
        }
    }
}
