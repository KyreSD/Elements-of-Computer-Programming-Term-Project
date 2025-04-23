import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    private int count = 0;
    private String currentChar;
    private boolean isRandom = true;
    private boolean randomize = true;
    private int textSize = 100;
    public Text() {
        randomizeChar();
    }
    
    public void act() {
        count++;
        if(count % 6 == 0 && randomize) {
            randomizeChar();
        }
    }
    
    private void randomizeChar() {
        //gets random number then converts to ASCII
        currentChar = String.valueOf((char)(Greenfoot.getRandomNumber(26) + 65));
        setImage(new GreenfootImage(currentChar, textSize, Color.WHITE, Color.BLACK));
        
    }
    
    public void setLetter(String letter) {
        isRandom = false;
        currentChar = letter;
        setImage(new GreenfootImage(currentChar, textSize, Color.WHITE, Color.BLACK));
        randomize = false;
    }
}
