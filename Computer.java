import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Actor
{
    /**
     * Act - do whatever the computer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage image = getImage();
        image.scale(740, 500);
        setImage(image);
    }
}
