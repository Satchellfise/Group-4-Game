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
    private final JFrame game=new JFrame();
    JPanel panel;
    
    public Frame(){
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setTitle("Final-Quest");
        game.setResizable(true);
        //Main_Screen main_screen=new Main_Screen(game);
        //JPanel panel=main_screen.getPanel();
        Battle_Panel battle_panel=new Battle_Panel(game);
        panel=battle_panel.getPanel();
        game.getContentPane().add(panel);
        game.pack();
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
    public void display() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            game.setVisible(true);
            }
        });
    }
}

