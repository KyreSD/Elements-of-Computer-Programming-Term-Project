/**
 * Write a description of class BossBackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class BackButton extends Actor {
    public BackButton() {
        setImage("BackArrowButton.png");
        getImage().scale(50,50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            openMyWorld();
        }
    }
    
    private void openMyWorld() {
        // This will edventually complete the BackArrow button.
        //I need to make getter method for finding all the players XP data
        // in order to set a new myWorld.  This is due to the xp perameters set
        // to my world now
    }
}
