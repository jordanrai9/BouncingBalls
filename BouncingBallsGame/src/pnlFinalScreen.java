/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: pnlFinalScreen.java
 Short description: final panel to display final score and rankings
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pnlFinalScreen extends JPanel {
    
    //declare variables
    JPanel pnlFinalScreenContainer;
    private JLabel lblGameOver;
    JLabel lblRanking;
    private pnlBouncingBalls pnlGame;
    JLabel lblFinalScore;
    
    public pnlFinalScreen(pnlBouncingBalls pnlGameOver){
        super();
        setBackground(Color.yellow);
        setBounds(new Rectangle(0,0,640,480));
        
        
        setLayout(null);
        
        pnlGame = pnlGameOver;
        
        //container
        pnlFinalScreenContainer = new JPanel();
        pnlFinalScreenContainer.setBounds(new Rectangle(0,0,640,480));
        pnlFinalScreenContainer.setLayout(null);
        pnlFinalScreenContainer.setBackground(Color.pink);
        
        lblGameOver = new JLabel ("<html><h1>Game Over</h1></html>");
        lblGameOver.setBounds(new Rectangle(220,10,200,70));
        pnlFinalScreenContainer.add(lblGameOver);
        
        lblFinalScore = new JLabel();
        lblFinalScore.setBounds(new Rectangle(220,90,200,100));
        pnlFinalScreenContainer.add(lblFinalScore);
        
        lblRanking = new JLabel ("<html><h1>Rankings:</h1></html>");
        lblRanking.setBounds(new Rectangle(100,50,600,300));
        pnlFinalScreenContainer.add(lblRanking);
        
        pnlFinalScreenContainer.setVisible(true);
        this.add(pnlFinalScreenContainer);
        
        
    }
    
}

