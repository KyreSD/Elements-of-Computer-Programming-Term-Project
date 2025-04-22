import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The starting title screen of the game.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    public static int SELECT = 0;
    
    /**
     * Constructor for objects of class TitleScreen.
     */
    public TitleScreen()
    {    
        super(800, 600, 1); 
        Greenfoot.start();
        showText("The Legend of Zelda: Echoes of the Code Catacombs", getWidth()/2, 200);
        
        // Add buttons
        addObject(new StartButton(), getWidth()/2, 300);
        addObject(new ControlButton(), getWidth()/2, 400);
        
        // Add visual cue for how to navigate
        showText("Use UP/DOWN arrows to navigate, ENTER to select", getWidth()/2, 500);
    }
    
    public void act() {
        // Handle button selection with up/down keys
        handleButtonNavigation();
    }
    
    /**
     * Method to handle button selection
     */
    private void handleButtonNavigation() {
        // Move selection down
        if (Greenfoot.isKeyDown("down") && SELECT == 0) {
            SELECT = 1;
            Greenfoot.delay(10); // Add delay to prevent too rapid selection
        }
        
        // Move selection up
        if (Greenfoot.isKeyDown("up") && SELECT == 1) {
            SELECT = 0;
            Greenfoot.delay(10);
        }
    }
    
    /**
     * Static method for buttons to query the current selection
     */
    public static int getSelection() {
        return SELECT;
    }
}
