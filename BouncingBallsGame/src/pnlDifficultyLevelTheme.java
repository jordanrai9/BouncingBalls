/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: pnlDifficultyLevelTheme.java
 Short description: allows user to select theme and difficulty
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Enumeration;

public class pnlDifficultyLevelTheme extends JPanel implements ActionListener {
    
    //declare variables
    private JLabel lblChooseChar;
    private JLabel lblChooseTheme, lblChooseDifficulty;
    private JRadioButton rbtnFootballPlayer, rbtnStudent, rbtnNittanyLion;
    private JRadioButton rbtnFootball, rbtnTHON, rbtnAlumni;
    private JRadioButton rbtnEasy, rbtnHard;
    private JPanel pnlChooseChar, pnlChooseTheme;
    private pnlOpenScreen mainMenu;
    public  JPanel pnlSelectContainer;
    private JButton btnGoToMainMenu1, btnStartGame1;
    private ButtonGroup chooseCharacter;
    private ButtonGroup chooseTheme;
    private ButtonGroup chooseDifficulty;
    private pnlBouncingBalls bouncingBalls;
    private JButton pennState;
    
    JLabel lblGameCharacter;
    JLabel lblGameTheme ;
    
    String Character;
    String Theme;
    String Difficulty;
    
    Timer tim;
    int delay;
            
            public pnlDifficultyLevelTheme(pnlOpenScreen mm){
                super();
              
                
                
                setLayout(null);
                mainMenu = mm;
                
                //container
                pnlSelectContainer = new JPanel();
                pnlSelectContainer.setBounds(new Rectangle(0,0,640,480));
                pnlSelectContainer.setLayout(null);
                pnlSelectContainer.setBackground(Color.pink);
                
                btnStartGame1 = new JButton ("Start Game");
                btnStartGame1.setBounds(new Rectangle(380,400,200,30));
                btnStartGame1.addActionListener(this);
                btnStartGame1.setOpaque(false);
                pnlSelectContainer.add(btnStartGame1);
          
                btnGoToMainMenu1 = new JButton("Go Back To Main Menu");
                btnGoToMainMenu1.setBounds(new Rectangle(60,400,200,30));
                btnGoToMainMenu1.addActionListener(this);
                pnlSelectContainer.add(btnGoToMainMenu1);
                
                Icon image = new ImageIcon("pennstate.png");
                pennState = new JButton(image);
                pennState.setBounds(new Rectangle(10, 100, 220, 250));
                pnlSelectContainer.add(pennState);
               
                JPanel pnlChooseTheme = new JPanel();
                pnlChooseTheme.setBackground(Color.pink);
                pnlChooseTheme.setBounds(new Rectangle(200,0,200,480));
                pnlChooseTheme.setLayout(null);
                
                
                lblChooseTheme = new JLabel("Choose Theme");
                lblChooseTheme.setBounds(new Rectangle(60,100,200,30));
                pnlChooseTheme.add(lblChooseTheme);
                
                //radio buttons
                rbtnFootball = new JRadioButton("Football");
                rbtnFootball.setActionCommand("THFB");
                rbtnFootball.setSelected(true);
                rbtnFootball.setBounds(new Rectangle(60,140,200,30));
                pnlChooseTheme.add(rbtnFootball);
                

                rbtnTHON = new JRadioButton("THON");
                rbtnTHON.setActionCommand("THTHON");
                rbtnTHON.setBounds(new Rectangle(60,180,200,30));
                pnlChooseTheme.add(rbtnTHON);

                rbtnAlumni = new JRadioButton("Alumni");
                rbtnAlumni.setActionCommand("AL");
                rbtnAlumni.setBounds(new Rectangle(60,220,200,30));
                pnlChooseTheme.add(rbtnAlumni);
                
                
           

    
                //Group the radio buttons.
                 chooseTheme = new ButtonGroup();
                 chooseTheme.add(rbtnFootball);
                 chooseTheme.add(rbtnTHON);
                 chooseTheme.add(rbtnAlumni);
                
                /*****
                 * 
                 * CHOOSE DIIFICULTY LEVEL
                 */ 
                
                JPanel pnlChooseDifficulty = new JPanel();
                pnlChooseDifficulty.setBackground(Color.pink);
                pnlChooseDifficulty.setBounds(new Rectangle(400,0,200,480));
                pnlChooseDifficulty.setLayout(null);
                
                
                lblChooseDifficulty = new JLabel("Choose Time/Speed");
                lblChooseDifficulty.setBounds(new Rectangle(60,100,200,30));
                pnlChooseDifficulty.add(lblChooseDifficulty);
                
                rbtnEasy = new JRadioButton("Easy");
                rbtnEasy.setActionCommand("Easy");
                rbtnEasy.setSelected(true);
                rbtnEasy.setBounds(new Rectangle(60,140,200,30));
                pnlChooseDifficulty.add(rbtnEasy);
                

                rbtnHard = new JRadioButton("Hard");
                rbtnHard.setActionCommand("Hard");
                rbtnHard.setBounds(new Rectangle(60,180,200,30));
                pnlChooseDifficulty.add(rbtnHard);
                
                lblGameCharacter = new JLabel();
                lblGameCharacter.setBounds(new Rectangle(450,0,200,30));
                pnlSelectContainer.add(lblGameCharacter);
                
                lblGameTheme = new JLabel();
                lblGameTheme.setBounds(new Rectangle(500,30,200,30));
                pnlSelectContainer.add(lblGameTheme);
                
           

    
                //Group the radio buttons.
                 chooseDifficulty = new ButtonGroup();
                 chooseDifficulty.add(rbtnEasy);
                 chooseDifficulty.add(rbtnHard);
                
                pnlSelectContainer.add(pnlChooseDifficulty);
                pnlSelectContainer.add(pnlChooseTheme);
                
                add(pnlSelectContainer);
                pnlSelectContainer.setVisible(true);
                
                bouncingBalls = new pnlBouncingBalls(this, mainMenu);
                add(bouncingBalls);
                bouncingBalls.setVisible(false);
                //timer when starting game
                delay = 1000; //milliseconds
                tim = new Timer(delay, bouncingBalls);
               
                
               
        
                 
            }
 public void actionPerformed(ActionEvent event){
     
     Object obj = event.getSource();
     
     if(obj.equals(btnGoToMainMenu1)){
        mainMenu.pnlSelectScreen.setVisible(false);
        mainMenu.pnlMenuContainer.setVisible(true);

   
        
     }
     
     
     if(obj.equals(btnStartGame1)){
         
         //SET UP TIMER FOR THE ENTIRE GAME
        
         //start timer for game and ball movement
        bouncingBalls.tim.start();
        bouncingBalls.timballs.start();
   
        // Get the selected options       
        
        String theme = getSelectedButton(chooseTheme);
        String difficulty = getSelectedButton(chooseDifficulty);

       
       bouncingBalls.setCharacterTheme(theme,difficulty);
       
        //display game panel
        bouncingBalls.setVisible(true);
        pnlSelectContainer.setVisible(false);
        
        
     }
   
     //get selcetd button from button group
 } public String getSelectedButton(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
 
 
}

