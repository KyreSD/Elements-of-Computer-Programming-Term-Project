/**
 * Write a description of class SettingsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SettingsButton extends Actor 
{
    private MyWorld gameWorld;
    public SettingsButton(MyWorld gameWorld) {
        //image file
        setImage("SettingsButton.png");
        //image sizer
        getImage().scale(200, 50);
        this.gameWorld = gameWorld;
    }
    private World PauseMenu;
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (gameWorld != null) {
                Greenfoot.setWorld(new SettingsMenu(gameWorld));
        }
    }
}
}
