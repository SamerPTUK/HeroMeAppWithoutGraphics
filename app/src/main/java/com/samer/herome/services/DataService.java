package com.samer.herome.services;

import com.samer.herome.R;

import java.util.ArrayList;

/**
 * Created by Samer AlShurafa on 1/12/2018.
 */

public class DataService {

    public static DataService getInstance() {
        return new DataService();
    }

    private ArrayList<Data> list;

    public DataService(){

        list = new ArrayList<>(6);

        // upper = 0, child : another number
        list.add(new Data(1, "Turtle Power", R.drawable.turtlepower_icon, 0));
        list.add(new Data(2, "Lightning", R.drawable.thorshammer_icon, 6));
        list.add(new Data(3, "Flight", R.drawable.supermancrest_icon, 0));
        list.add(new Data(4, "Web Slinging", R.drawable.spiderweb_icon, 3));
        list.add(new Data(5, "Laser Vision", R.drawable.laservision_icon, 1));
        list.add(new Data(6, "Super Strength", R.drawable.superstrength_icon, 0));
    }


    public String[] getTitles(int ID) {
        String[] titles = new String[2];
        int id = ID - 1;

        if(list.get(id).getUpper() == 0) { // selected : upper
            titles[0] = list.get(id).getTitle(); // upper
            titles[1] = list.get( getChildID(ID) ).getTitle(); // child
        } else { // selected : not upper
            titles[1] = list.get(id).getTitle(); // child
            titles[0] = list.get( list.get(id).getUpper() - 1 ).getTitle(); // upper
        }

        return titles;
    }


    public int[] getResources(int ID) {
        int[] resources = new int[2];
        int id = ID - 1;

        if(list.get(id).getUpper() == 0) { // selected : upper
            resources[0] = list.get(id).getResource(); // upper
            resources[1] = list.get( getChildID(ID) ).getResource(); // child
        } else { // selected : not upper
            resources[1] = list.get(id).getResource(); // child
            resources[0] = list.get( list.get(id).getUpper() - 1 ).getResource(); // upper
        }

        return resources;
    }


    private int getChildID(int upperID) {
             if(list.get(0).getUpper() == upperID) return 0;
        else if(list.get(1).getUpper() == upperID) return 1;
        else if(list.get(2).getUpper() == upperID) return 2;
        else if(list.get(3).getUpper() == upperID) return 3;
        else if(list.get(4).getUpper() == upperID) return 4;
        else                                       return 5;
    }




}





class Data {

    private int id;
    private String title;
    private int resource;
    private int upper;



    public Data(int id, String title, int resource, int upper) {
        setId(id);
        setTitle(title);
        setResource(resource);
        setUpper(upper);
    }




    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getResource() {
        return resource;
    }

    private void setResource(int resource) {
        this.resource = resource;
    }

    public int getUpper() {
        return upper;
    }

    private void setUpper(int upper) {
        this.upper = upper;
    }
}







