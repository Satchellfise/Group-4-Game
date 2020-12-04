/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author danielcohen
 * This class manually, later possible randomly, provides constructor data to 
 * construct each location. Call this class from main. This class should not 
 * be instantiated (I think)
 */
public class LocationConstructor {
    
    
    public static Location createPlaceHolder() {
        ArrayList<String> neighbors = new ArrayList<> (Arrays.asList("null"));
        
        ArrayList<String> npcs = new ArrayList<> (Arrays.asList("Null"));
        
        ArrayList<String> objects = new ArrayList<> (Arrays.asList("Null"));
        
        String name = "Null Location";
        
        Location placeHolder = new Location (neighbors, npcs, objects, name);
        
        return placeHolder;
    }
    
    public static Location createTown1() {
        
        ArrayList<String> neighbors = new ArrayList<> (Arrays.asList("Temple1", "Dungeon1", "Route1"));
        
        ArrayList<String> npcs = new ArrayList<> (Arrays.asList("Alice", "Bob", "Carl"));
        
        ArrayList<String> objects = new ArrayList<> (Arrays.asList("Wooden Plank", "Empty Bottle", "Wooden Pole"));
        
        String name = "Town1";
        
        Location town1 = new Location (neighbors, npcs, objects, name);
        
        return town1;
    }
    
    
    public static Location createTemple1() {
        
        ArrayList<String> neighbors = new ArrayList<> (Arrays.asList("Town1"));
        
        ArrayList<String> npcs = new ArrayList<> (Arrays.asList("Priest"));
        
        ArrayList<String> objects = new ArrayList<> (Arrays.asList("Sword in the Stone"));
        
        String name = "Temple1";
        
        Location temple1 = new Location (neighbors, npcs, objects, name);
        
        return temple1;
    }
    
    
    public static Location createDungeon1() {
        ArrayList<String> neighbors = new ArrayList<> (Arrays.asList("Town1"));
        
        ArrayList<String> npcs = new ArrayList<> (Arrays.asList("Goblin", "Dark Souls Skeleton", "Steve, the Unforgivable"));
        
        ArrayList<String> objects = new ArrayList<> (Arrays.asList("Potion2", "Battleaxe", "Sacred Treasure"));
        
        String name = "Dungeon1";
        
        Location dungeon1 = new Location (neighbors, npcs, objects, name);
        
        return dungeon1;
    }    
}
