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
 * This class contains all save data and whatnot. Has getters and setters and letters and betters
 */
public class PlayerState {
    
    ArrayList<String>  _inventory = new ArrayList<>(); // list of items :)
    Location _location;
    private int money = 0;
    private boolean inTown;
    int HP = 100;
    
    public PlayerState() {
        money = 0;
        inTown = true;
        _inventory.add("Potion1");
        _inventory.add("Fists");
        _inventory.add("MacGuffin");
    }
    
    public int getMoney() {
        return money;
    }
        
    public void buy(int price) {
        money = money - price;
    }
    
    public void sell(int price) {
        money = money + price;
    }
    
    public void addItem(String item) {
        _inventory.add(item);
    }
    
    // public void useItem() - case by case, may be good to store this elsewhere
    
    public void setLocation(Location destination) {
        _location = destination;
    }
    
    public Location getLocation() {
        return _location;
    }
    
}
