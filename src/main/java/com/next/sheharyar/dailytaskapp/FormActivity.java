package com.next.sheharyar.dailytaskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FormActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    TextView editName, editDisc;
    TasksInfoListAdapter tasksInfoListAdapter;
    ListView tasksList;
    List<Tasks> listOfTasks;
    ArrayList<Tasks> insertTasks = new ArrayList<>();
    ArrayList<AllTasks> insertAll = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreference sharedPreference = new SharedPreference();
        setContentView(R.layout.activity_form);

        editName = (TextView)findViewById(R.id.edtName);
        editDisc = (TextView)findViewById(R.id.edtDiscription);

//        tasksList = (ListView)findViewById(R.id.tasksList);
//        tasksInfoListAdapter = new TasksInfoListAdapter(getApplicationContext(), listOfTasks);
//        tasksList.setAdapter(tasksInfoListAdapter);
//        tasksList.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.done_icon){
            passDataToMainActivity();
//            MenuItem item1 = (MenuItem)findViewById(R.id.done_icon);
//            item1.setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }

    private void passDataToMainActivity() {

        try {
            String getName = editName.getText().toString();
            String getDisc = editDisc.getText().toString();

            Bundle extras = new Bundle();
            // adding key value pairs to this bundle
            extras.putString("NAME_KEY", getName);
            extras.putString("Disc_KEY", getDisc);


            Intent intent = new Intent(getApplicationContext(), AddTasksActivity.class);
            // attach the bundle to the Intent objec
            intent.putExtras(extras);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }
}
