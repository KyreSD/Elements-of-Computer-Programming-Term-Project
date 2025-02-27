import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(600, 400, 1); 
        Placeholder placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        Enemy enemy = new Enemy();
        addObject(new Placeholder("FullSheetBoy.png", 4, 5), 300, 200);
        addObject(new Enemy(), 400, 200);
        addObject(new Enemy(), 400, 100);
        addObject(new Enemy(), 400, 300);
        
    }
}
