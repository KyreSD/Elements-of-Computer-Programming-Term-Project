/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class Portal extends Actor {
    public Portal() {
        setImage("portal.png");
        getImage().scale(50,50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new BossWorld());
        }
    }
}
