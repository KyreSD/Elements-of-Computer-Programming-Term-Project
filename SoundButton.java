/**
 * Write a description of class SoundOffButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SoundButton extends Actor
{
    private boolean soundOn = true;
    public SoundButton() {
        //image file
        setImage("SoundOnButton.png");
        //image sizer
        getImage().scale(40, 40);
    }
    public void soundButtonFunctionality() {
        if (soundOn == true) {
            setImage("SoundOffButton.png");
            soundOn = false;
        } else {
            setImage("SoundOnButton.png");
            soundOn = true;
        }
        //image sizer for On and Off Button
        getImage().scale(40, 40);
    }
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            soundButtonFunctionality();
        }
    }
}
