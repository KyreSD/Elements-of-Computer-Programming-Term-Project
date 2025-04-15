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
        super(800, 600, 1); 
        Greenfoot.start();
        showText("The Legend of Zelda: Echos of the Code Catatcombs", 400, 200);
        addObject(new StartButton(), 400, 300);
        addObject(new ControlButton(), 400, 400);
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
