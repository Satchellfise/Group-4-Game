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
 */

//This entire class is just a format, the main will need to instantiate
// each location, giving it neighbors and NPCs
public class Location {
   
    ArrayList<String>  _neighbors = new ArrayList<>(); // list of neighbors :)
    
    ArrayList<String> _npcs = new ArrayList<>(); // list of NPCs in a given town, will change when create NPC class
    
    ArrayList<String> _objects = new ArrayList<>();
    
    public Location(ArrayList<String> neighbors, ArrayList<String> npcs, ArrayList<String> objects) {
        _neighbors = neighbors;
        _npcs = npcs;
        _objects = objects;
    }
    
    public void printNeighbors() {
        for (int i = 0; i <_neighbors.size(); i++ ) {
            System.out.println(_neighbors.get(i));
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
