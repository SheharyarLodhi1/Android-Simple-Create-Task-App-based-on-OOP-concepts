package com.next.sheharyar.dailytaskapp;

/**
 * Created by sheharyar on 2/1/2019.
 */

public class Tasks {

    private String name;
    private String disc;

    public Tasks(String name, String disc) {
        this.name = name;
        this.disc = disc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }
}
