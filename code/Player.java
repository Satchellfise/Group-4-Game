package pkgfinal.quest.battleTest;

import java.util.ArrayList;

/**
 *
 * @author satch
 */
public class Player extends Statable{
    
    /*protected static int hp = 100;
    protected static int atk = 5;
    protected static int def = 5;
    protected static String name = "Player";
*/
    protected static Player player=new Player();
    
    private Player(){
        setHP(100);
        setAtk(5);
        setDef(5);
        changeName("Player");
    }
    
    public static Player getPlayer(){
        return player;
    }
    
}