package com.next.sheharyar.dailytaskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddTasksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    TasksInfoListAdapter tasksInfoListAdapter;
    ListView tasksList;
    ArrayList<Tasks> listOfTasks;
    ArrayList<Tasks> insertTasks = new ArrayList<>();
    ArrayList<AllTasks> insertAll = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        SharedPreference sharedPreference = new SharedPreference();
        setContentView(R.layout.activity_add_tasks);
        SharedPreference sharedPreference = new SharedPreference();
//        test();
//        getTasksFromForm();
        tasksList = (ListView)findViewById(R.id.tasksList);
        getTasksFromForm();
//        tasksInfoListAdapter = new TasksInfoListAdapter(getApplicationContext(), listOfTasks);
//        tasksList.setAdapter(tasksInfoListAdapter);
//        tasksList.setOnItemClickListener(this);


    }

//    private void test() {
//        Tasks tasks1 = new Tasks("First Task", "Hi this is my first Task");
//        Tasks tasks2 = new Tasks("Second Task", "Hi this is my second Task");
//
//        listOfTasks = new ArrayList<Tasks>();
//        listOfTasks.add(tasks1);
//        listOfTasks.add(tasks2);
//    }

    private void getTasksFromForm() {
        try {
            //get the intent in the target activity
            Intent intent = getIntent();
            //get the attached bundle from the intent
            Bundle extras = intent.getExtras();
            //Extracting the stored data from the bundle
            String task_name = extras.getString("NAME_KEY");
            String task_disc = extras.getString("Disc_KEY");

            Tasks tasks = new Tasks(task_name, task_disc);
            tasks.setName(task_name);
            tasks.setDisc(task_disc);
//            insertTasks = new ArrayList<Tasks>();
//            insertTasks.add(tasks);
            ArrayList<Tasks> test = DataHolder.getInstance().tasks;
            test.add(tasks);
            for (int i = 0; i < insertTasks.size(); i++ ){
                String s = insertTasks.get(i).toString();
                SharedPreference sharedPreference = new SharedPreference();
                sharedPreference.addFavorite(getApplicationContext(), insertTasks.get(i));

            }
            tasksInfoListAdapter = new TasksInfoListAdapter(getApplicationContext(), test);
            tasksList.setAdapter(tasksInfoListAdapter);
            tasksInfoListAdapter.notifyDataSetChanged();
            tasksList.setOnItemClickListener(this);

            Toast.makeText(getApplicationContext(),"Added to List Successfully", Toast.LENGTH_LONG).show();
            getData();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getData() {
       SharedPreference sharedPreference = new SharedPreference();
              listOfTasks = sharedPreference.getFavorites(getApplicationContext());
              String s = listOfTasks.toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_icon){
            startActivity(new Intent(getApplicationContext(),FormActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Tasks tasks = (Tasks)parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), tasks.toString(), Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
       SharedPreference sharedPreference = new SharedPreference();
       sharedPreference.addFavorite(getApplicationContext(), listOfTasks.get(position));
       Toast.makeText(getApplicationContext(),"Added to List Successfully", Toast.LENGTH_LONG).show();

       return true;
    }
}
