/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: myJFrame.java
 Short description: creates frame components 
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class myJFrame extends JFrame {
    
    public myJFrame()
    {
        super("The Penn State Student Game");

        //adds main screen to frame
        pnlOpenScreen pnlMainM = new pnlOpenScreen();
        add(pnlMainM, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
        
        
    }
   
}
