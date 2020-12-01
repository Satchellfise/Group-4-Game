/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author danielcohen
 * This entire class is just a format, the main will need to instantiate
 * each location, giving it neighbors and NPCs. Probably good to create a 
 * factory class that constructs them and passes them back to main, to save
 * space in the main class.
 */

public class Location {
   
    ArrayList<String>  _neighbors = new ArrayList<>(); // list of neighbors :)
    
    ArrayList<String> _npcs = new ArrayList<>(); // list of NPCs in a given town, will change when create NPC class
    
    ArrayList<String> _objects = new ArrayList<>();
    
    /*
    Storing all this data as Strings and then decoding them is a bad hack,
    I know. Will hopefully change when we fully flesh out these classes.
    I don't know how else to store the list of adjacent locations, though.
    */
    
    final String _name;
    
    public Location(ArrayList<String> neighbors, ArrayList<String> npcs, ArrayList<String> objects, String name) {
        _neighbors = neighbors;
        _npcs = npcs;
        _objects = objects;
        _name = name;
    }
    
    public void printNeighbors() {
        for (int i = 0; i <_neighbors.size(); i++ ) {
            System.out.println(_neighbors.get(i));
        }
    }
    
    public void printNpcs() {
        for (int i = 0; i <_npcs.size(); i++ ) {
            System.out.println(_npcs.get(i));
        }
    }
    
     public void printObjects() {
        for (int i = 0; i <_objects.size(); i++ ) {
            System.out.println(_objects.get(i));
        }
    }
    
    public boolean isNeighbor(String toCheck) {
        boolean toReturn = false;
        for (int i = 0; i <_neighbors.size(); i++ ) {
            if (toCheck.equals(_neighbors.get(i))) {
                toReturn = true;
            }
        }
        return toReturn;
    }
    
    
    
    
}
