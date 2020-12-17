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
package pkgfinal.quest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import pkgfinal.quest.battleTest.*;
/**
 *
 * @author drf11
 */
public class Frame {
    //Creates the frame and a panel for future use.
    private final JFrame game=new JFrame();
    JPanel panel;
    
    public Frame(){
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setTitle("Final-Quest");
        game.setResizable(true);
        
        //This will be default
        //Main_Screen main_screen=new Main_Screen(game);
        //JPanel panel=main_screen.getPanel();
        
        //This is for testing porpeses
        Battle_Panel battle_panel=new Battle_Panel(game,600,600);
        
        //Sets the panel variable
        panel=battle_panel.getPanel();
        
        //adds the panel to the frame
        game.getContentPane().add(panel);
        game.pack();
    }
    
    /**
     * I don't remember if I used this ever. (Gets the panel)
     * @return the panel
     */
    public JPanel getPanel(){
        return panel;
    }
    
    /**
     * It's what allows people to see the frame (I don't actually know how this thing works)
     */
    public void display() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            game.setVisible(true);
            }
        });
    }
}

