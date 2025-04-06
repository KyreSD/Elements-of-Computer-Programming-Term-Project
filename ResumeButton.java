/**
 * Write a description of class ResumeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ResumeButton extends Actor 
{
    private MyWorld gameWorld;
    //Sets Resume button
    public ResumeButton(MyWorld gameWorld) {
        //image file
        setImage("ResumeButton.png");
        //Image Sizer
        getImage().scale(200,50);
        this.gameWorld = gameWorld;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (gameWorld != null) {
                gameWorld.resumeGame();
                Greenfoot.setWorld(gameWorld);
            }
        }
    }
}
