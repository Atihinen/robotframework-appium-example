package fi.groupd9.todoexampleapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fi.groupd9.todoexampleapp.R;
import fi.groupd9.todoexampleapp.presenter.TodoPresenterImpl;
import fi.groupd9.todoexampleapp.presenter.interfaces.TodoView;

public class TodoActivity extends AppCompatActivity implements TodoView {
    private TodoPresenterImpl presenter;
    private ArrayAdapter<String> adapter;
    private ArrayList todos;
    private ArrayList todoCont;
    @BindView(R.id.todoList) ListViewCompat todoList;
    @BindView(R.id.addTodoBtn) Button addTodoBtn;
    @BindView(R.id.todoText) EditText todoTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        ButterKnife.bind(this);
        todos = new ArrayList<String>();
        todoCont = new ArrayList();
        presenter = new TodoPresenterImpl(this);
        addTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTodo();
            }
        });
        updateTodoAdapter();
    }

    private void updateTodoAdapter() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todos);
        todoList.setAdapter(adapter);

    }

    private void addTodo(){
        String todoContent = todoTxt.getText().toString();
        presenter.addTodo(todoContent);
    }

    @Override
    public void addSuccess(String content) {
        todos.add(content);
        //updateTodoAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addError() {
        String errorMsg = getResources().getString(R.string.empty_todo);
        todoTxt.setError(errorMsg);
    }
}
