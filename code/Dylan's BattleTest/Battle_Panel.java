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
    //private final JFrame game=new JFrame();
    private final JPanel battle_panel=new JPanel();
    private final ArrayList<JButton> enemy_button=new ArrayList<JButton>();
    protected final JButton attack=new JButton("ATTACK");
    protected final JButton defend=new JButton("DEFEND");
    protected final JButton items=new JButton("ITEMS");
    protected final JButton run=new JButton("RUN AWAY");
    protected final JLabel narrator=new JLabel("YOU HAVE ENTERED COMBAT!");
    private final JFrame _frame;
    private final Battle test = new Battle(1, 1, 1, 0,this);
    private final ArrayList<Combatant> enemies=test.getEnemies();
    private final JLabel enemy_list=new JLabel("");
    private final JLabel choices=new JLabel("Choose an Action");
    private String e_l="<html>";
    private final Player player=Player.getPlayer();
    private final JLabel stats=new JLabel("<html><p>HP: "+player.getHP()+"/"+player.getBaseHP()+"</p><p>Atk: "+player.getAtk()+"</p><p>Def: "+player.getDef()+"</p></html>");
    
    public Battle_Panel(JFrame frame){
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
        enemy_list.setVerticalAlignment(SwingConstants.CENTER);
        enemy_list.setHorizontalAlignment(SwingConstants.CENTER);
        choices.setVerticalAlignment(SwingConstants.CENTER);
        choices.setHorizontalAlignment(SwingConstants.CENTER);
        stats.setVerticalAlignment(SwingConstants.CENTER);
        stats.setHorizontalAlignment(SwingConstants.CENTER);
        narrator.setVerticalAlignment(SwingConstants.CENTER);
        narrator.setHorizontalAlignment(SwingConstants.CENTER);
        
        _frame=frame;
        battle_panel.setBackground(Color.WHITE);//Place holder in case we want to change it.
        battle_panel.setPreferredSize(new Dimension(600,600)); //Can change later
        battle_panel.setLayout(null);
        
        narrator.setBounds(10,360,580,50);
        choices.setBounds(10,10,580,50);
        enemy_list.setBounds(100,400,580,280);
        stats.setBounds(10,400,240,280);
        attack.setBounds(10,80,580,50);
        defend.setBounds(10,150,580,50);
        items.setBounds(10,220,580,50);
        run.setBounds(10,290,580,50);
        
        attack.addActionListener(this);
        defend.addActionListener(this);
        items.addActionListener(this);
        run.addActionListener(this);
        battle_panel.addComponentListener(new PanelListen());
        
        battle_panel.add(narrator);
        battle_panel.add(choices);
        battle_panel.add(enemy_list);
        battle_panel.add(stats);
        battle_panel.add(attack);
        battle_panel.add(defend);
        battle_panel.add(items);
        battle_panel.add(run);
    }
    
    public JPanel getPanel(){
        return battle_panel;
    }
    
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
    
    private class PanelListen implements ComponentListener{
        public void componentHidden(ComponentEvent e) {}
        public void componentMoved(ComponentEvent e) {}
        public void componentResized(ComponentEvent e) {
            int width=battle_panel.getWidth();
            int height=battle_panel.getHeight();
            int spacing=(int)(height/8.6);
        }
        public void componentShown(ComponentEvent e) {}
    }
    
    //public void 
    
}
