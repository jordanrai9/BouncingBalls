/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: pnlOpenScreen.java
 Short description: first panel when application runs
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pnlOpenScreen extends JPanel implements ActionListener{
    
    //declare variables
    private JLabel lblGameTitle;
    private JLabel lblMainMenu;
    private JButton btnStartGame;
    private JButton btnInstructions;
    pnlInstructions Instructions;
    pnlDifficultyLevelTheme pnlSelectScreen;
    JPanel pnlMenuContainer;
    JLabel lblRankings;
    JLabel lblGameOver;
    private JButton ballsImage;
    
    public pnlOpenScreen (){
        
        super();
        setBackground(Color.green);
        
        setLayout(null);
        
        //container
        pnlMenuContainer = new JPanel();
        pnlMenuContainer.setBackground(Color.green);
        pnlMenuContainer.setBounds(new Rectangle(0,0,680,480));
        
        pnlMenuContainer.setLayout(null);
        
        lblGameTitle = new JLabel ("<html><h1>Welcome to Bouncing Balls!</h1></html>");
        lblGameTitle.setBounds(new Rectangle(220,10,200,70));
        pnlMenuContainer.add(lblGameTitle);
        
        lblMainMenu = new JLabel ();
        lblMainMenu.setBounds(new Rectangle(220,10,200,70));
        pnlMenuContainer.add(lblMainMenu);
        
        btnStartGame = new JButton ("Start Game");
        btnStartGame.setBounds(new Rectangle(380,200,200,30));
        btnStartGame.addActionListener(this);
        pnlMenuContainer.add(btnStartGame);
        
        btnInstructions = new JButton ("Go to Instructions");
        btnInstructions.setBounds(new Rectangle(60,200,200,30));
        btnInstructions.addActionListener(this);
        pnlMenuContainer.add(btnInstructions);
        
        Icon image = new ImageIcon("bouncingballs.png");
        ballsImage = new JButton(image);
        ballsImage.setBounds(new Rectangle(120, 250, 400, 200));
        pnlMenuContainer.add(ballsImage);
        
        Instructions = new pnlInstructions(this);
        Instructions.setBounds(new Rectangle(0,0,680,480));
        Instructions.setVisible(false);
        add(Instructions);
        
        pnlSelectScreen = new pnlDifficultyLevelTheme(this);
        pnlSelectScreen.setBounds(new Rectangle(0,0,680,480));
        pnlSelectScreen.setVisible(false);
        add(pnlSelectScreen);
        
        pnlMenuContainer.setVisible(true);
        this.add(pnlMenuContainer);
        
        lblRankings = new JLabel ();
        lblRankings.setBounds(new Rectangle(0,0,640,480));
        add(lblRankings);
        
        lblGameOver = new JLabel ("<html><h1>Game Over</h1></html>");
        lblGameOver.setBounds(new Rectangle(220,10,200,70));
        add(lblGameOver);
    }
    
    public void actionPerformed(ActionEvent event){
     
     Object obj = event.getSource();
     //sets this panel not visible
     if(obj.equals(btnInstructions)){
       
        Instructions.setVisible(true);
        pnlMenuContainer.setVisible(false);
        pnlSelectScreen.setVisible(false);

        
     }
     if(obj.equals(btnStartGame)){
         
         pnlSelectScreen.setVisible(true);
         Instructions.setVisible(false);
         pnlMenuContainer.setVisible(false);
         
     }
    }
    
     public void finishGame(String rankings){
        remove(pnlMenuContainer);
        remove(this.pnlSelectScreen);
        remove(this.Instructions);
        lblRankings.setText(rankings);
        lblRankings.setVisible(true);
        lblGameOver.setVisible(true);
     }
}
