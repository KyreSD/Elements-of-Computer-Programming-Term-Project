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
        Placeholder placeholder = new Placeholder();
        Enemy enemy = new Enemy();
        
        addObject(new Placeholder(), 300, 200);
        addObject(new Enemy(), 100, 100);
        addObject(new Enemy(), 200, 100);
    }
}
