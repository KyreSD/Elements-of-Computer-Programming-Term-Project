/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class Key extends Actor
{
    private GifImage keyImage;
    public Key() {
        keyImage = new GifImage("key.gif");
        setImage(keyImage.getCurrentImage());
        
        
    }
    
    public void act() {
        setImage(keyImage.getCurrentImage());
    }
}
