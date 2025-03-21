import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{

    private Placeholder placeholder;
    
    public World2()
    {    
        super(600, 400, 1); 
        placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        addObject(placeholder, 300, 200);
    }
    
    public World2(int xp, int health, int playerX, int playerY){
        super(600, 400,1);
        placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        addObject(placeholder, playerX, playerY);
    }
}
