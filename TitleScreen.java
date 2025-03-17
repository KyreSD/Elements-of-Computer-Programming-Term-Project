import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    public static int SELECT = 0;
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Greenfoot.start();
        addObject(new StartButton(), 300, 200);
        addObject(new ControlsButton(), 300, 300);
        
        
    }
    public static void selectButton(){
        if(Greenfoot.isKeyDown("down")){
            SELECT = 1;
        }
        if(Greenfoot.isKeyDown("up")){
            SELECT = 0;
        }
    }
}
