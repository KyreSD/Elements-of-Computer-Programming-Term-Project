/**
 * Write a description of class SaveGameButton here.
 * 
 * @author (your name) 
 * @version (a fversion number or a date)
 */
import greenfoot.*;
public class SaveGameButton extends Actor
{
    public SaveGameButton() {
        //image file
        setImage("SaveGame.png");
        //image sizer
        getImage().scale(200, 50);
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            System.out.println("Save Button Works");
        }
    }
}
