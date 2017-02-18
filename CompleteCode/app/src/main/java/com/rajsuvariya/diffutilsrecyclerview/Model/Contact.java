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

    @Override
    public int compareTo(Object o) {
        Contact compare = (Contact) o;

        if (compare.getName().equals(this.name) && compare.getPhonenumber().equals(this.phonenumber)){
            return 0;
        }
        return 1;
    }
}
