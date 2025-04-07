/**
 * Write a description of class SettingsBackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SettingsBackButton extends Actor
{
    private MyWorld gameWorld;
    
    public SettingsBackButton(MyWorld gameWorld) {
        //image file
        setImage("BackArrowButton.png");
        //image sizer
        getImage().scale(80, 40);
        this.gameWorld = gameWorld;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (gameWorld != null) {
                Greenfoot.setWorld(new PauseMenu(gameWorld));
        }
    }
}
}
