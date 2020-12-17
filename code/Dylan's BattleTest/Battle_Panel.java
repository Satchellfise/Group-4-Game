/*
 * ===============================================================================================================================================
 * 
 * @author     Dylan Flink
 * Class       CS173 Fall 2019
 * Assignment: 
 * 
 * Summary:
 * 
 * ===============================================================================================================================================
 */
package pkgfinal.quest.battleTest;

/*
 * ===============================================================================================================================================
 * 
 * @author     Dylan Flink
 * Class       CS173 Fall 2019
 * Assignment: 
 * 
 * Summary:
 * 
 * ===============================================================================================================================================
 */
package pkgfinal.quest.battleTest;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author drf11
 */
public class Battle_Panel extends JPanel implements ActionListener{
    //These are for resizing
    private int _width;
    private int _height;
    private int button_height=_height/12;
    private int button_width=_width-20;
    private int spacing=button_height+_height/30;
    private int stat_spacing=spacing*5+_height/20;
    
    //The all important Panel
    private final JPanel battle_panel=new JPanel();
    
    //enemy_button will let the player select an enemy, attack will display the enemies able to be attacked, defend will increase player defense,items, will allow the user to select items, run will have the user run from combat.
    private final ArrayList<JButton> enemy_button=new ArrayList<>();
    protected final JButton attack=new JButton("ATTACK");
    protected final JButton defend=new JButton("DEFEND");
    protected final JButton items=new JButton("ITEMS");
    protected final JButton run=new JButton("RUN AWAY");
    
    //The players class and a list of some of their stats
    private final Player player=Player.getPlayer();
    private final JLabel stats=new JLabel("<html><p>HP: "+player.getHP()+"/"+player.getBaseHP()+"</p><p>Atk: "+player.getAtk()+"</p><p>Def: "+player.getDef()+"</p></html>");
    
    //Choices gives the user prompts, enemy_list will display the names of the enemies, narrator will give some extra info on the current condition of the battle
    private final JLabel choices=new JLabel("Choose an Action");
    private final JLabel enemy_list=new JLabel("");
    protected final JLabel narrator=new JLabel("YOU HAVE ENTERED COMBAT!");
    
    //This is just in case we need it in the future.
    //private final JFrame _frame;
    
    //What this panel uses to do things
    private final Battle test = new Battle(1, 1, 1, 0,this);
    
    //list of the enemies
    private final ArrayList<Combatant> enemies=test.getEnemies();
    private String e_l="<html>";
    
    /**
     * The Battle_Panel will be what the user sees.
     * @param frame Not currently used, but is there as a just in case we need it in the future.
     * @param width The current width of the previous panel so it stays consistent while moving between panels
     * @param height The current height of previous panel so it stays consistent while moving between panels.
     */
    public Battle_Panel(JFrame frame, int width, int height){
        _width=width;
        _height=height;
        
        //Gets the enemies from the battle class and makes buttons for them and puts them in the enemy list string to be input into the label
        for(int x=0;x<enemies.size();x++){
            if(enemies.get(x)!=null){
                enemy_button.add(new JButton(enemies.get(x).getName()));
                enemy_button.get(x).addActionListener(this);
                e_l+="<p>"+enemies.get(x).getName()+"</p>";
            }else{
                enemies.remove(x);
            }
        }
        e_l+="<html>";
        enemy_list.setText(e_l);
        
        //Centers the labels horizontally
        enemy_list.setHorizontalAlignment(SwingConstants.CENTER);
        choices.setHorizontalAlignment(SwingConstants.CENTER);
        stats.setHorizontalAlignment(SwingConstants.CENTER);
        narrator.setHorizontalAlignment(SwingConstants.CENTER);
        
        //_frame=frame;(not currently used
        
        //creates the panelwith these settings
        battle_panel.setBackground(Color.WHITE);//Place holder in case we want to change it.
        battle_panel.setPreferredSize(new Dimension(_width,_height));
        battle_panel.setLayout(null); //Don't know how to use actual layouts
        
        
        //These are for resizing purpeses
        button_height=_height/12;
        button_width=_width-20;
        spacing=button_height+_height/30;
        stat_spacing=spacing*5+_height/20;
        
        //Sets the location of the buttons
        choices.setBounds(10,10,button_width,button_height);
        attack.setBounds(10,10+spacing,button_width,button_height);
        defend.setBounds(10,10+2*spacing,button_width,button_height);
        items.setBounds(10,10+3*spacing,button_width,button_height);
        run.setBounds(10,10+4*spacing,button_width,button_height);
        narrator.setBounds(10,10+5*spacing,button_width,_height/20);
        enemy_list.setBounds(_width/2,10+stat_spacing,button_width/2,_height/3);
        stats.setBounds(10,10+stat_spacing,button_width/2,_height/3);
        
        //adds the action listeners to the buttons sothat they do things as well asthe component listener to the panel so we can resize things properly.
        attack.addActionListener(this);
        defend.addActionListener(this);
        items.addActionListener(this);
        run.addActionListener(this);
        battle_panel.addComponentListener(new PanelListen());
        
        //Ads everything to the panel
        battle_panel.add(narrator);
        battle_panel.add(choices);
        battle_panel.add(enemy_list);
        battle_panel.add(stats);
        battle_panel.add(attack);
        battle_panel.add(defend);
        battle_panel.add(items);
        battle_panel.add(run);
    }
    
    /**
     * This is for when we want other things to be able to use the panel
     * @return the JPanel that was made.
     */
    public JPanel getPanel(){
        return battle_panel;
    }
    
    /**
     * The event lister
     * @param e Whatever triggered the listener
     */
    public void actionPerformed(ActionEvent e){
        boolean battleEnd=false;
        if(e.getSource().equals(attack)&&!enemies.isEmpty()){
            choices.setText("Choose an Enemy");
            battle_panel.remove(narrator);
            battle_panel.remove(attack);
            battle_panel.remove(defend);
            battle_panel.remove(items);
            battle_panel.remove(run);
            battle_panel.repaint();
            for(int x=0;x<enemy_button.size();x++){
                enemy_button.get(x).setBounds(10,10+70*(x+1),580,50);
                battle_panel.add(enemy_button.get(x));
            }
        }else if(e.getSource().equals(defend)){
            test.defend();
            test.enemyPhase();
            stats.setText("<html><p>HP: "+player.getHP()+"/"+player.getBaseHP()+"</p><p>Atk: "+player.getAtk()+"</p><p>Def: "+player.getDef()+"</p></html>");
        }else if(e.getSource().equals(items)){
            test.items();
            test.enemyPhase();
            stats.setText("<html><p>HP: "+player.getHP()+"/"+player.getBaseHP()+"</p><p>Atk: "+player.getAtk()+"</p><p>Def: "+player.getDef()+"</p></html>");
        }
        else if(e.getSource().equals(run)){
            battleEnd=test.runAway();
        }else{
            for(int x=0;x<enemy_button.size();x++){
                if(e.getSource().equals(enemy_button.get(x))){
                    test.attack(player,enemies.get(x));
                    narrator.setText("You dealt " + test.damage + " to the " + enemies.get(x).getName());
                    for(int y=0;y<enemy_button.size();y++){
                        battle_panel.remove(enemy_button.get(y));
                    }
                    if(enemies.get(x).getHP()<1){
                        int location=e_l.indexOf(enemies.get(x).getName());
                        e_l=e_l.substring(0,location)+"DEAD"+e_l.substring(location+enemies.get(x).getName().length());
                        enemy_list.setText(e_l);
                        enemy_button.remove(x);
                        enemies.remove(x);
                    }
                    battle_panel.repaint();
                    test.enemyPhase();
                    choices.setText("Choose an Action");
                    stats.setText("<html><p>HP: "+player.getHP()+"/"+player.getBaseHP()+"</p><p>Atk: "+player.getAtk()+"</p><p>Def: "+player.getDef()+"</p></html>");
                }
            }
        }
        if(battleEnd || enemies.isEmpty())
            test.fightCycle();
    }
    
    /**
     * The component lister
     */
    private class PanelListen implements ComponentListener{
        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        /**
         * Triggers when the frame/panel is resized
         * @param e No clue honestly
         */
        public void componentResized(ComponentEvent e) {
            //resets the variables to current size.
            _width=battle_panel.getWidth();
            _height=battle_panel.getHeight();
            
            button_height=_height/12;
            button_width=_width-20;
            spacing=button_height+_height/30;
            stat_spacing=spacing*5+_height/20;
            
            //resizes the labels and the buttons
            choices.setBounds(10,10,button_width,button_height);
            attack.setBounds(10,10+spacing,button_width,button_height);
            defend.setBounds(10,10+2*spacing,button_width,button_height);
            items.setBounds(10,10+3*spacing,button_width,button_height);
            run.setBounds(10,10+4*spacing,button_width,button_height);
            narrator.setBounds(10,10+5*spacing,button_width,_height/20);
            enemy_list.setBounds(_width/2,10+stat_spacing,button_width/2,_height/3);
            stats.setBounds(10,10+stat_spacing,button_width/2,_height/3);
        }
        public void componentShown(ComponentEvent e) {}
    }
    
    //public void 
    
}
