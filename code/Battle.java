package pkgfinal.quest.battleTest;
import java.util.Scanner;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author satch
 */
public class Battle {
    private Combatant a;
    private Combatant b;
    private Combatant c;
    private Combatant d;
    private Battle_Panel panel;
    private JPanel battle_panel;
    protected int damage;
    boolean battleEnd = false;
    Player player=Player.getPlayer();
    
    private static String[] enemies = {
            //0 is no enemy
            "",
            //1 - 4, bat
            "Bat", "20", "5", "1"
        };
    
    public Battle(int enemy1, int enemy2, int enemy3, int enemy4,Battle_Panel _panel) {
        if(enemy1 > 0) {
            a = new Combatant(enemies[enemy1], Integer.parseInt
        (enemies[enemy1 + 1]), Integer.parseInt(enemies[enemy1 + 2]), 
                    Integer.parseInt(enemies[enemy1 + 3]));
        }
        
        if(enemy2 > 0) {
            b = new Combatant(enemies[enemy2], Integer.parseInt
        (enemies[enemy2 + 1]), Integer.parseInt(enemies[enemy2 + 2]), 
                    Integer.parseInt(enemies[enemy2 + 3]));
        }
        
        if(enemy3 > 0) {
            c = new Combatant(enemies[enemy3], Integer.parseInt
        (enemies[enemy3 + 1]), Integer.parseInt(enemies[enemy3 + 2]), 
                    Integer.parseInt(enemies[enemy3 + 3]));
        }
        
        if(enemy4 > 0) {
            d = new Combatant(enemies[enemy4], Integer.parseInt
        (enemies[enemy4 + 1]), Integer.parseInt(enemies[enemy4 + 2]), 
                    Integer.parseInt(enemies[enemy4 + 3]));
        }
        panel=_panel;
        battle_panel=panel.getPanel();
        //fightCycle();
        playerPhase();
    }
    
    public ArrayList<Combatant> getEnemies(){
        ArrayList<Combatant> toReturn=new ArrayList<Combatant>();
        toReturn.add(a);
        toReturn.add(b);
        toReturn.add(c);
        toReturn.add(d);
        return toReturn;
    }
    
    public int damageCalc(int aAtk, int bDef) {
        int damage = aAtk - bDef;
        if (damage < 1) {
            damage = 1;
        }
        
        return damage;
    }
    
    public void playerPhase() {
        //System.out.println("What would you like to do?");
        battle_panel.add(panel.attack);
        battle_panel.add(panel.defend);
        battle_panel.add(panel.items);
        battle_panel.add(panel.run);
        battle_panel.add(panel.narrator);
        player.setDef(player.getBaseDef());
        //System.out.println("Select your target:");
    }
    
    public void attack(Statable offence, Statable defense){
        damage = damageCalc(offence.getAtk(), defense.getDef());
        defense.changeHP(-damage);
        if(defense.getHP() < 1) 
            panel.narrator.setText("You killed the " + defense.getName());
    }
    
    public void defend(){
        player.changeDef(player.getDef()*3);
        panel.narrator.setText("You defend against incoming attacks");
    }
    
    public void items(){
        //System.out.println("You use a potion");
        player.changeHP(player.getHP()+20);
        if(player.getHP() > player.getBaseHP()) {
            player.changeHP(player.getBaseHP());
        }
        panel.narrator.setText("You healed for 20 health. Current health: " + player.getHP());
    }
    
    public boolean runAway(){
        panel.narrator.setText("You try to run away!");
        battleEnd=true;
        return battleEnd;
    }
    
    public void enemyPhase() {
        if(a!=null&&a.getHP() > 0) {
            attack(a,player);
            //System.out.println("The " + a.getName() + " dealt " + damage + " damage to you.");
        }
        
        if(b!=null&&b.getHP() > 0) {
            attack(b,player);
            //System.out.println("The " + b.getName() + " dealt " + damage + " damage to you.");
        }
        
        if(c!=null&&c.getHP() > 0) {
            attack(c,player);
            //System.out.println("The " + c.getName() + " dealt " + damage + " damage to you.");
        }
        
        if(d!=null&&d.getHP() > 0) {
            attack(d,player);
            //System.out.println("The " + d.getName() + " dealt " + damage + " damage to you.");
        }
        playerPhase();
    }
    
    public void fightCycle() {
        /*
        System.out.println("You encounter " + a.getName() + " " + b.getName() +
                " " + c.getName() + " " + d.getName());
*/
        if(battleEnd) {
            panel.narrator.setText("You escaped!");
        }
        if(player.getHP() > 0) {
            panel.narrator.setText("You win!");
        }
        if(player.getHP() < 0) {
            panel.narrator.setText("You died. Try again!");
        }
    }
}

