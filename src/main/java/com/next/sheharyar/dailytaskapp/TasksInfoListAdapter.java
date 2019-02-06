package com.next.sheharyar.dailytaskapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheharyar on 2/1/2019.
 */

public class TasksInfoListAdapter extends BaseAdapter {     //extends ArrayAdapter<Tasks>
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Tasks> tasks;                      //List<Tasks> tasks;
    SharedPreference sharedPreference;

    public TasksInfoListAdapter(Context contxt, ArrayList<Tasks> arrayListTasks){
//        super(contxt, R.layout.listview_item, arrayListTasks);
        context = contxt;
        layoutInflater = LayoutInflater.from(contxt);
        tasks = arrayListTasks;
//        this.context = contxt;
//        this.tasks = arrayListTasks;
        sharedPreference = new SharedPreference();
    }
    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Tasks getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.listview_item,null, false);
            holder = new ViewHolder();
            holder.taskName = (TextView)convertView.findViewById(R.id.itemsTexts);
            holder.taskDisc = (TextView)convertView.findViewById(R.id.itemsDisc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        final Tasks finalTaskPosition = tasks.get(position);
        holder.taskName.setText(finalTaskPosition.getName());
        holder.taskDisc.setText(finalTaskPosition.getDisc());
        return convertView;
//        Tasks tasks = (Tasks) getItem(position);
//        holder.taskName.setText(tasks.getName());
//        holder.taskDisc.setText(tasks.getDisc());
//        return convertView;
    }

    /*Checks whether a particular product exists in SharedPreferences*/
    public boolean checkFavoriteItem(Tasks checkTasks) {
        boolean check = false;
        List<Tasks> favorites = sharedPreference.getFavorites(context);
        if (favorites != null) {
            for (Tasks tasks : favorites) {
                if (tasks.equals(checkTasks)) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public class ViewHolder{
        TextView taskName;
        TextView taskDisc;

    }

//    @Override
    public void add(Tasks myTasks) {
        this.add(myTasks);
        tasks.add(myTasks);
        notifyDataSetChanged();
    }
//
//    @Override
    public void remove(Tasks myRemovalTasks) {
        this.remove(myRemovalTasks);
        tasks.remove(myRemovalTasks);
        notifyDataSetChanged();
    }
}
