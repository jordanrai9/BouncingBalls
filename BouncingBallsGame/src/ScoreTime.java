/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*File name: ScoreTime.java
 Short description: get and sets rankings and time
 IST 242 Assignment:  BouncingBallsGame - GUI Application
 @author Gayatri Rai, Chase Barros, Vishal Desai
 date of last revision: 04/25/18
 details of the revision: none
*/
public class ScoreTime {
    
    //declare variables
    private String Ranking = "";
    private String Time = "";
    
    public ScoreTime(){
        
    }
    
    //get ranking
     public String getRanking() {
        return Ranking;
    }
    
     //set ranking
    public void setRanking(String Ranking) {
        this.Ranking = Ranking;
    }
    
    //get time
    public String getTime() {
        return Time;
    }
    
    //set time
    public void setTime(String Time) {
        this.Time = Time;
    }
    
}


