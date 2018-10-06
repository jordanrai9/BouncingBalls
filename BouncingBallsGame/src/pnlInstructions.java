/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrai36
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pnlInstructions extends JPanel implements ActionListener {
    
    JLabel lblGameTitle;
    JLabel lblInstructions;
    JButton btnGoToMainMenu;
    pnlOpenScreen mainMenu;
    
    public pnlInstructions(pnlOpenScreen mm){
    
        super();
        setBackground(Color.yellow);
        
        setLayout(null);
        mainMenu = mm;
        
        lblGameTitle = new JLabel ();
        lblGameTitle.setBounds(new Rectangle(220,10,200,70));
        add(lblGameTitle);
        
        lblInstructions = new JLabel ("<html><h1>Instructions:</h1> <p> " +
                " A user will be playing a game in which he or she can choose"
                + " a theme (Penn State football, THON, or alumni) and difficulty level (Easy and Hard)." + 
                " The game will begin and 'balls' will bounce around the screen. The user will collect points "
                + "by clicking the balls as many times as they can in the allotted time." +
                " The game will end when time runs out. Then, a final screen" +
                " will be shown, displaying the player's rankings according" +
                " to his/her performance.</html>");
        lblInstructions.setBounds(new Rectangle(10,50,600,300));
        add(lblInstructions);
        
        btnGoToMainMenu = new JButton("Go Back To Main Menu");
        btnGoToMainMenu.setBounds(new Rectangle(60,400,200,30));
        btnGoToMainMenu.addActionListener(this);
        add(btnGoToMainMenu);
}
    
    public void actionPerformed(ActionEvent event){
     Object obj = event.getSource();
     //go back to opening screen
     if(obj.equals(btnGoToMainMenu)){
         mainMenu.Instructions.setVisible(false);
         mainMenu.pnlMenuContainer.setVisible(true);
         validate();
         repaint();
         
     }
    
}
}

