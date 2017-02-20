package com.rajsuvariya.diffutilsrecyclerview.DataFactory;

import com.rajsuvariya.diffutilsrecyclerview.Model.Contact;

import java.util.ArrayList;

/**
 * Created by kuliza-319 on 18/2/17.
 */

public class DataGenerator {

    public static ArrayList<Contact> getData(){
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Raj Suvariya", "9099809050"));
        contacts.add(new Contact("Rajat Talesra", "9723124260"));
        contacts.add(new Contact("Nishit Chattrala", "8460770916"));
        contacts.add(new Contact("Rajan Pipaliya", "8141081381"));
        contacts.add(new Contact("Nilay Shrimali", "7046295423"));
        contacts.add(new Contact("Saurav Pratihar", "9033399314"));
        return contacts;
    }

    // TODO(5): update the data
    public static ArrayList<Contact> getUpdatedData(){
        ArrayList<Contact> contacts= getData();
        contacts.get(0).setPhonenumber("9067250043");
        contacts.get(1).setName("Rajat Talesra (CEO)");
        return contacts;
    }
}
