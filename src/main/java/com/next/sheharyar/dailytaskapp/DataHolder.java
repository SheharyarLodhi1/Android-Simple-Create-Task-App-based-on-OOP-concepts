package com.next.sheharyar.dailytaskapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheharyar on 2/2/2019.
 */

public class DataHolder {
    final ArrayList<Tasks> tasks = new ArrayList<>();

    private  DataHolder(){

    }

    static DataHolder getInstance(){
        if (instance == null){
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}
