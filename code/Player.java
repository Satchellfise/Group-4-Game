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
public class Player  extends Statable{
    
    protected static int hp = 100;
    protected static int atk = 5;
    protected static int def = 5;
    protected static String name = "Player";
    int money = 100;

    protected static Player player=new Player();
    Location _location;
    
    private Player(){
        
        setHP(100);
        setAtk(5);
        setDef(5);
        changeName("Player");
         _location = LocationConstructor.createTown1();
        LocationConstructor.createDungeon1();
        LocationConstructor.createTemple1();
    }
    
    public static Player getPlayer(){
        return player;
    }
    
     public Location getLocation() {
        return _location;
    }
     
     public void setLocation(String destinationName) {
        LocationMaster lom = LocationMaster.getInstance();
        Location destination = lom.parseLocation(destinationName);
        boolean adjacent = _location.isNeighbor(destinationName);
        if (adjacent) {
            _location = destination;
        } else {
            System.out.println("These two locations don't connect");
        }
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
    
    
}


