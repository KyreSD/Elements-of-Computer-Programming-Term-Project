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
    private Actor[] characters = new Actor[3]; //using array to store 3 characters
    /**
     * Constructor for objects of class CharacterSelection.
     * 
     */
    
    public CharacterSelection()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        characters[0]= new FullSheetBoyImage();
        characters[1] = new LinkImage();
        characters[2] = new RetroImage();
        
        addObject(characters[0], 150 , 300);
        addObject(characters[1], 300 , 300);
        addObject(characters[2], 450, 300);
        
        
        //displayCharacter = new Actor();
    }
    public static void pickCharacter(){
        if(Greenfoot.isKeyDown("right")&& SELECT < 2){  
            SELECT++;  
            Greenfoot.delay(10);
        }
        if(Greenfoot.isKeyDown("left") && SELECT > 0){
            SELECT--;
            Greenfoot.delay(10);
        }
    }
}
