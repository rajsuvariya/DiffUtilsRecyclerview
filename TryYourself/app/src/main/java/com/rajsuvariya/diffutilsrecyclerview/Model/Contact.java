package com.rajsuvariya.diffutilsrecyclerview.Model;

/**
 * Created by kuliza-319 on 16/2/17.
 */

public class Contact implements Comparable{

    private String name;
    private String phonenumber;

    public Contact(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // TODO writeCompareTo method
    @Override
    public int compareTo(Object o) {
       return 0;
    }
}
