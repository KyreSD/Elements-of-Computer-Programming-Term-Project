/**
 * Write a description of class LoadSaveButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class LoadSaveButton extends Actor
{
    public LoadSaveButton() {
        //image file
        setImage("LoadSaveButton.png");
        //image sizer
        getImage().scale(200, 50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("Load Save Button Works");
        }
    }
}
