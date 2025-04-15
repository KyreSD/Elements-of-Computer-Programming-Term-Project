import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CharacterSelection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelection extends World
{
    public static int SELECT_CH = 0;
    private Actor[] characters = new Actor[3]; //using array to store 3 characters
    /**
     * Constructor for objects of class CharacterSelection.
     * 
     */

    public CharacterSelection()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,400,1);
        
        characters[0]= new SelectBoy();
        characters[1] = new SelectLink();
        characters[2] = new SelectRetro();
        
        showText("Choose Your Character", 300, 100);
        showText("Use space to Choose", 300, 150);
        addObject(characters[0], 150 , 300);
        addObject(characters[1], 300 , 300);
        addObject(characters[2], 450, 300);
        
        //displayCharacter = new Actor();
    }

    public static void pickCharacter(){
        if(Greenfoot.isKeyDown("right")&& SELECT_CH < 2){  
            SELECT_CH+=1;
            Greenfoot.delay(10);
        }
        if(Greenfoot.isKeyDown("left") && SELECT_CH > 0){
            SELECT_CH-=1;
            Greenfoot.delay(10);
        }
        
        if(Greenfoot.isKeyDown("space")&& SELECT_CH==0){
            Greenfoot.setWorld(new WorldMain(new PlayerOne(0, 4, 5), 300, 200));
        }
        
        if(Greenfoot.isKeyDown("space")&& SELECT_CH==1){
            Greenfoot.setWorld(new WorldMain(new PlayerOne(), 300, 200));
        }
        
        if(Greenfoot.isKeyDown("space")&& SELECT_CH==2){
            Greenfoot.setWorld(new WorldMain(new PlayerOne(2, 4, 4), 300, 200));
        }
    }

}
