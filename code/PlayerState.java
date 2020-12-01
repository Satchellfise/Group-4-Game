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
    
    private static PlayerState _instance;
    ArrayList<String>  _inventory = new ArrayList<>(); // list of items :)
    Location _location;
    private int money;
    private boolean inTown;
    int HP = 100;
    
    private PlayerState() {
        money = 0;
        inTown = true;
        _inventory.add("Potion1");
        _inventory.add("Fists");
        _inventory.add("MacGuffin");
    }
    
    public PlayerState getInstance() {
        
        if (_instance == null) {
            _instance = new PlayerState();
        }
        return _instance;
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
