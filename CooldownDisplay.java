import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CooldownDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CooldownDisplay extends Actor
{
    String text;
    public CooldownDisplay(String initialText) {
        text = initialText;
        updateText();
    }
    public void setText(String newText) {
        text = newText;
        updateText();
    }
    private void updateText() {
        GreenfootImage img = new GreenfootImage(text, 20, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(img);
    }
}
