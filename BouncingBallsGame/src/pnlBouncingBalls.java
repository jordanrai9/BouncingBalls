/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: pnlBouncingBalls.java
 Short description: makes buttons "bounce" on panel
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pnlBouncingBalls extends JPanel implements ActionListener, MouseListener {
    
    //declare variables
    JButton score;
    JButton st1,st2,st3, st4, st5, st6;
    int trackScore = 0;
    int lastPicture = -1;
    public int posX1, posY1;        // position
    public int VelocityX1, VelocityY1;        // velocity
    public int radius1;  // radius
    public int posX2, posY2;        // position
    public int VelocityX2, VelocityY2;        // velocity
    public int radius2;  // radius
    public int posX3, posY3;        // position
    public int VelocityX3, VelocityY3;        // velocity
    public int radius3;  // radius
    public int posX4, posY4;        // position
    public int VelocityX4, VelocityY4;        // velocity
    public int radius4;  // radius
    public int posX5, posY5;        // position
    public int VelocityX5, VelocityY5;        // velocity
    public int radius5;  // radius
    public int posX6, posY6;        // position
    public int VelocityX6, VelocityY6;        // velocity
    public int radius6;  // radius
    ImageIcon[] images = new ImageIcon[3];
    Image[] img = new Image[3];
    
    
    
    JPanel pnlBouncingBallsContainer;
    JButton btnDone;
    JLabel lblQuestion;
    JTextField txtAnswer;
    
    JProgressBar progressBar;
    int gameTime = 120;
    int minutes;
    int seconds;
    int progressValue = 0;
    
    private String Character;
    private String Theme;
    private String Difficulty;
    
    JLabel lblGameCharacter;
    JLabel lblGameTheme ;
    JLabel lblGameEndIn;

    boolean st1NotClicked = true;
    boolean st2NotClicked = true;
    boolean st3NotClicked = true;
    boolean st4NotClicked = true;
    boolean st5NotClicked = true;
    boolean st6NotClicked = true;
    
    pnlDifficultyLevelTheme select;

    private XML_242 xml2;
    ScoreTime[] STarr = new ScoreTime[3];
    ScoreTime[] STarrtemp = new ScoreTime[3];
    
    Timer tim;
    int delay;
    
    Timer timballs;
    int delay2;
    int timeElapsed = 0;
    int totalTime;
    boolean gameOver = false;

    pnlDifficultyLevelTheme SelectScreen;
    pnlOpenScreen main;
    
    pnlFinalScreen finalScreen;
    JPanel pnlBouncyBallsContainer;
    
    public pnlBouncingBalls(pnlDifficultyLevelTheme select, pnlOpenScreen Main) {
        super();

        setBackground(Color.red);
        setBounds(new Rectangle(0,0,640,480));

        setLayout(null);
        SelectScreen = select;
        
        main = Main;

        //TIMER for movement of balls

        delay = 100; //milliseconds
        tim = new Timer(delay,this);

        tim.start();
        
        ///TIMER 2 For Time Left ////
     
         delay2 = 1000; //milliseconds
         timballs = new Timer(delay2,this);
         
        //final screen object to go to final screen when finished
        finalScreen = new pnlFinalScreen(this);
        add(finalScreen);
        finalScreen.setVisible(false);
        
        //container
        pnlBouncingBallsContainer = new JPanel();
        pnlBouncingBallsContainer.setBounds(new Rectangle(0,400,640,150));
        pnlBouncingBallsContainer.setLayout(null);
        pnlBouncingBallsContainer.setBackground(Color.yellow);
        
        //container
        pnlBouncyBallsContainer = new JPanel();
        pnlBouncyBallsContainer.setBounds(new Rectangle(0,0,640,400));
        pnlBouncyBallsContainer.setLayout(null);
        pnlBouncyBallsContainer.setBackground(Color.red);
        add(pnlBouncyBallsContainer);
        
        
        score = new JButton("Current score: " + trackScore);
        score.setBounds(new Rectangle(10,10,200,30)); //fix bounds, put at bottom of frame
        pnlBouncyBallsContainer.add(score);
     
        //random position/velocity for ball 1
        posX1 = 100;
        posY1 = 100;
        VelocityX1 = 2;
        VelocityY1 = 5;
        radius1 = 120;

        //random position/velocity for ball 2        
        posX2 = 380;
        posY2 = 200;
        VelocityX2 = -4;
        VelocityY2 = -2;
        
        radius2 = 120;
        
        //random position/velocity for ball 3
        posX3 = 50;
        posY3 = 75;
        VelocityX3 = 2;
        VelocityY3 = -4;
        
        radius3 = 120;
        
        //random position/velocity for ball 4
        posX4 = 10;
        posY4 = 10;
        VelocityX4 = 5;
        VelocityY4 = -3;
        radius4 = 120;

        //random position/velocity for ball 5        
        posX5 = 10;
        posY5 = 10;
        VelocityX5 = 4;
        VelocityY5 = -1;
        
        radius5 = 120;

        ////random position/velocity for ball 6
        posX6 = 10;
        posY6 = 75;
        VelocityX6 = 3;
        VelocityY6 = -4;
        
        radius6 = 120;
        
        for(int i =0; i < 3; i++){
            int j = i+1;
            images[i] = new ImageIcon("images/BouncyBall" + j + ".png");
            img[i] = images[i].getImage() ;
            img[i] = img[i].getScaledInstance( 120, 120,  java.awt.Image.SCALE_SMOOTH ) ;
            images[i] = new ImageIcon( img[i] );
        }
        
        //ball 1 button        
        st1 = new JButton();
        
        st1.setBorderPainted(false);
        st1.setContentAreaFilled(false);
        st1.setFocusPainted(false);
        st1.setOpaque(true);
        
        st1.addMouseListener(this); //random generator, within bounds
        st1.setBounds(10, 10, 120, 120);
        pnlBouncyBallsContainer.add(st1);
     
        
        //ball 2 button
        st2 = new JButton();
        
        st2.setBorderPainted(false);
        st2.setContentAreaFilled(false);
        st2.setFocusPainted(false);
        st2.setOpaque(true);
        
        st2.addMouseListener(this); //random generator, within bounds
        st2.setBounds(100, 100, 120, 120);
        pnlBouncyBallsContainer.add(st2);
        
        //ball 3 button
        st3 = new JButton();
        
        st3.setBorderPainted(false);
        st3.setContentAreaFilled(false);
        st3.setFocusPainted(false);
        st3.setOpaque(false);
        
        st3.addMouseListener(this); //random generator, within bounds
        st3.setBounds(50, 50, 120, 120); 
        pnlBouncyBallsContainer.add(st3);
        
        //ball 4 button
        st4 = new JButton();
        
        st4.setBorderPainted(false);
        st4.setContentAreaFilled(false);
        st4.setFocusPainted(false);
        st4.setOpaque(false);
        
        st4.addMouseListener(this); //random generator, within bounds
        st4.setBounds(110, 10, 120, 120);
        pnlBouncyBallsContainer.add(st4);
     
        //ball 5 button
        st5 = new JButton();
        
        st5.setBorderPainted(false);
        st5.setContentAreaFilled(false);
        st5.setFocusPainted(false);
        st5.setOpaque(false);
        
        st5.addMouseListener(this); //random generator, within bounds
        st5.setBounds(200, 100, 120, 120);
        
        pnlBouncyBallsContainer.add(st5);
     
        //ball 6 button
        st6 = new JButton();
        
        st6.setBorderPainted(false);
        st6.setContentAreaFilled(false);
        st6.setFocusPainted(false);
        st6.setOpaque(false);
        
        st6.addMouseListener(this); //random generator, within bounds
        st6.setBounds(150, 50, 120, 120); 
        pnlBouncyBallsContainer.add(st6);
        
        xml2 = new XML_242();


        btnDone = new JButton ("Done");
        btnDone.setBounds(new Rectangle(400,0,200,30));
        btnDone.addActionListener(this);
        pnlBouncingBallsContainer.add(btnDone);

        //progress bar for time left
        progressBar = new JProgressBar(0,gameTime);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(new Rectangle(200,0,200,100));
        pnlBouncingBallsContainer.add(progressBar);
        
        lblGameCharacter = new JLabel();
        lblGameCharacter.setBounds(new Rectangle(10,5,200,30));
        pnlBouncingBallsContainer.add(lblGameCharacter);

        lblGameTheme = new JLabel();
        lblGameTheme.setBounds(new Rectangle(10,30,200,30));
        pnlBouncingBallsContainer.add(lblGameTheme);

        add(pnlBouncingBallsContainer);

               
    }
    
       public void actionPerformed(ActionEvent event){
       
     
         Object obj = event.getSource();
         
        
         if(obj.equals(btnDone)){
           //go to final screen
           finalScreen.lblFinalScore.setText("Final Score: " + getScore());
           finalScreen.setVisible(true);
           rankScores();
           finalScreen.pnlFinalScreenContainer.setVisible(true);
           remove(pnlBouncingBallsContainer);
           remove(pnlBouncyBallsContainer);
           

             
         }
         
         if(obj == timballs){
             progressValue = progressValue + 1;
        //update time left with timer from selection panel
        int secondsRemaining = gameTime-progressValue;
        
         //end game and rank scores when time runs out
        if (secondsRemaining == 0) {
            finalScreen.lblFinalScore.setText("Final Score: " + getScore());
            finalScreen.setVisible(true);
            finalScreen.pnlFinalScreenContainer.setVisible(true);
            remove(pnlBouncingBallsContainer);
            remove(pnlBouncyBallsContainer);
             rankScores();
        }
        //time remaining
        int minutes = secondsRemaining/60;
        int seconds = secondsRemaining-(minutes*60);
        
        //display on progress bar
        progressBar.setString("Time left = " + minutes + ":" + seconds);
        progressBar.setValue(progressValue);
             
             
         }
         
         if(obj == tim){
             
             move();
             repaint();
         }
    }
  public void paintComponent(Graphics g) {
       
      //repaint buttons in new positions
           st1.setBounds(new Rectangle(posX1, posY1,120,120));
           
           st2.setBounds(new Rectangle(posX2, posY2,120,120));
         
           st3.setBounds(new Rectangle(posX3, posY3,120,120));
          
           st4.setBounds(new Rectangle(posX4, posY4,120,120));
           
           st5.setBounds(new Rectangle(posX5, posY5,120,120));
          
           st6.setBounds(new Rectangle(posX6, posY6,120,120));

       
       super.paintComponent(g);
    }
  //adds the velocities to positions, and keeps buttons within frame
  //also calls function to reverse direction of button movement when hit frame edge
    public void move () {
       int rposX1 = posX1 + VelocityX1;
       int rposY1 = posY1 + VelocityY1;
       if (rposX1 + radius1 > 640 || rposX1 < 0 ) VerticalWallBounce1();
       if (rposY1 + radius1 > 400 || rposY1 < 0) HorizontalWallBounce1();
        posX1 = posX1 + VelocityX1;
        posY1 = posY1 + VelocityY1;

       int rposX2 = posX2 + VelocityX2;
       int rposY2 = posY2 + VelocityY2;
       if (rposX2 + radius2 > 640 || rposX2 < 0 ) VerticalWallBounce2();
       if (rposY2 + radius2 > 400 || rposY2 < 0) HorizontalWallBounce2();
        posX2 = posX2 + VelocityX2;
        posY2 = posY2 + VelocityY2;

       int rposX3 = posX3 + VelocityX3;
       int rposY3 = posY3 + VelocityY3;
       if (rposX3 + radius3 > 640 || rposX3 < 0 ) VerticalWallBounce3();
       if (rposY3 + radius3 > 400 || rposY3 < 0) HorizontalWallBounce3();
        posX3 = posX3 + VelocityX3;
        posY3 = posY3 + VelocityY3;
        
        
       int rposX4 = posX4 + VelocityX4;
       int rposY4 = posY4 + VelocityY4;
       if (rposX4 + radius4 > 640 || rposX4 < 0 ) VerticalWallBounce4();
       if (rposY1 + radius4 > 400 || rposY4 < 0) HorizontalWallBounce4();
        posX4 = posX4 + VelocityX4;
        posY4 = posY4 + VelocityY4;

       int rposX5 = posX5 + VelocityX5;
       int rposY5 = posY5 + VelocityY5;
       if (rposX5 + radius5 > 640 || rposX5 < 0 ) VerticalWallBounce5();
       if (rposY5 + radius5 > 400 || rposY5 < 0) HorizontalWallBounce5();
        posX5 = posX5 + VelocityX5;
        posY5 = posY5 + VelocityY5;

       int rposX6 = posX6 + VelocityX6;
       int rposY6 = posY6 + VelocityY6;
       if (rposX6 + radius6 > 640 || rposX6 < 0 ) VerticalWallBounce6();
       if (rposY6 + radius6 > 400 || rposY6 < 0) HorizontalWallBounce6();
       posX6 = posX6 + VelocityX6;
       posY6 = posY6 + VelocityY6;
        
    }
    
    //functions to reverse velocity directions (horizonatl and vertical) of buttons
    private void VerticalWallBounce1() {
        VelocityX1 = -VelocityX1;
    }

    private void HorizontalWallBounce1() {
        VelocityY1 = -VelocityY1;
    }
    
    private void VerticalWallBounce2() {
        VelocityX2 = -VelocityX2;
    }
    

    // bounce of horizontal wall by reflecting y-velocity
    private void HorizontalWallBounce2() {
        VelocityY2 = -VelocityY2;
    }
    private void VerticalWallBounce3() {
        VelocityX3 = -VelocityX3;
    }

    // bounce of horizontal wall by reflecting y-velocity
    private void HorizontalWallBounce3() {
        VelocityY3 = -VelocityY3;
    }
    
     private void VerticalWallBounce4() {
        VelocityX4 = -VelocityX4;
    }

    private void HorizontalWallBounce4() {
        VelocityY4 = -VelocityY4;
    }
    
    private void VerticalWallBounce5() {
        VelocityX5 = -VelocityX5;
    }
    

    // bounce of horizontal wall by reflecting y-velocity
    private void HorizontalWallBounce5() {
        VelocityY5 = -VelocityY5;
    }
    private void VerticalWallBounce6() {
        VelocityX6 = -VelocityX6;
    }

    // bounce of horizontal wall by reflecting y-velocity
    private void HorizontalWallBounce6() {
        VelocityY6 = -VelocityY6;
    }
    
    
    public void mouseClicked(MouseEvent e){
        Object obj = e.getSource();
        
        //update score for mouse click
        if (obj == st1){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
           
            
        }
        if (obj == st2){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
            
        }
        if (obj == st3){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
           
        }
        
        if (obj == st4){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
           
        }
        if (obj == st5){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
            
        }
        if (obj == st6){
            updateScore(1);
            score.setText("Current Score = " + Integer.toString(trackScore));
         
        }
    }
    
    public void mousePressed(MouseEvent e){};
    
    public void mouseEntered(MouseEvent e){};
    
    public void mouseExited(MouseEvent e){};
   
    public void mouseReleased(MouseEvent e){};
       
    public void setCharacterTheme(String theme, String difficulty){
        
        Theme = theme;
        Difficulty = difficulty;
        
        
        st1.setVisible(true);
        st2.setVisible(true);
        st3.setVisible(true);
        st4.setVisible(true);
        st5.setVisible(true);
        st6.setVisible(true);
          
        //set images for theme
        if (Theme.equals("Alumni")) {
            st1.setIcon(images[0]);
            st2.setIcon(images[0]);
            st3.setIcon(images[0]);
            st4.setIcon(images[0]);
            st5.setIcon(images[0]);
            st6.setIcon(images[0]);

        }
        if (Theme.equals("THON")) {
            st1.setIcon(images[1]);
            st2.setIcon(images[1]);
            st3.setIcon(images[1]);
            st4.setIcon(images[1]);
            st5.setIcon(images[1]);
            st6.setIcon(images[1]);

        }
        if (Theme.equals("Football")) {
            st1.setIcon(images[2]);
            st2.setIcon(images[2]);
            st3.setIcon(images[2]);
            st4.setIcon(images[2]);
            st5.setIcon(images[2]);
            st6.setIcon(images[2]);

        }
        
        
        //difficulty (speed of balls)
        if (Difficulty.equals("Easy")) {
            tim.setDelay(50);
        } else if (Difficulty.equals("Hard")) {
            tim.setDelay(15);
        } 
         
    }
    
       //rank scores and store scores with XML
        public void rankScores(){
    
        xml2.openReaderXML("XMLFiles/Rankings");
            
            STarr[0] = new ScoreTime();
            STarr[0] = (ScoreTime) xml2.ReadObject();
            
            STarr[1] = new ScoreTime();
            STarr[1] = (ScoreTime) xml2.ReadObject();
            
            STarr[2] = new ScoreTime();
            STarr[2] = (ScoreTime) xml2.ReadObject();
            
            xml2.closeReaderXML();
            
            STarrtemp[0] = new ScoreTime();
            STarrtemp[1] = new ScoreTime();
            STarrtemp[2] = new ScoreTime();
            
            
            if(trackScore >= Integer.parseInt(STarr[0].getRanking())){
                STarrtemp[0].setRanking(Integer.toString(trackScore));
                STarrtemp[1].setRanking(STarr[0].getRanking());
                STarrtemp[2].setRanking(STarr[1].getRanking());
                               

                }
            else if((trackScore >= Integer.parseInt(STarr[1].getRanking())) &&
            (trackScore < Integer.parseInt(STarr[0].getRanking()))){
                STarrtemp[0].setRanking(STarr[0].getRanking());
                STarrtemp[1].setRanking(Integer.toString(trackScore));
                STarrtemp[2].setRanking(STarr[1].getRanking());
                

            }
            else if((trackScore >= Integer.parseInt(STarr[2].getRanking())) && 
            (trackScore < Integer.parseInt(STarr[1].getRanking()))){
                STarrtemp[0].setRanking(STarr[0].getRanking());
                STarrtemp[1].setRanking(STarr[1].getRanking());
                STarrtemp[2].setRanking(Integer.toString(trackScore));
            }
            else /*(finalScore < Integer.parseInt(STarr[2].getRanking()))*/{
                STarrtemp[0].setRanking(STarr[0].getRanking());
                STarrtemp[1].setRanking(STarr[1].getRanking());
                STarrtemp[2].setRanking(STarr[2].getRanking());
            }
            
            String rankings ="<html>";
                    
            
            for (int i=0; i<=2; i++){
                rankings = rankings + "<br>" + "Ranking = " + Integer.toString (i+1) +
                           " score = " + STarrtemp[i].getRanking() + 
                           "<br>";
                
            }
            
            finalScreen.lblRanking.setText(rankings);
            
            
            
            xml2.openWriterXML("XMLFiles/Rankings");
            
             for (int i=0; i<=2; i++){
                xml2.writeObject(STarrtemp[i]);
                
            }
            xml2.closeWriterXML();
             main.finishGame(rankings);

 }
   //add point
   public int updateScore(int score){
       return trackScore = trackScore + 1;
   }
   //get score
   public int getScore(){
       return trackScore;
   }
}
   


