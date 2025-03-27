import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelection extends World
{
    public static int SELECT = 0;
    /**
     * Constructor for objects of class CharacterSelection.
     * 
     */
    
    public CharacterSelection()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new FullSheetBoyImage(), 300 , 300);
        addObject(new linkImage(), 200 , 300);
        
        
        //displayCharacter = new Actor();
    }
    public static void pickCharacter(){
        if(Greenfoot.isKeyDown("right")){
            SELECT = 1;
        }
        if(Greenfoot.isKeyDown("left")){
            SELECT = 0;
        }
    }
}
