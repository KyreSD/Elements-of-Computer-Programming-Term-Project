import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Glitch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Glitch extends Actor
{
    int counter = 0;
    /**
     * Act - do whatever the Glitch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        counter+=1;
        int rand = Greenfoot.getRandomNumber(9)+1;
        if (counter % rand == 0){
        setImage(new GreenfootImage("               ", 24, Color.WHITE, Color.BLACK));    
    }else{
        setImage(new GreenfootImage("ERROR()", 24, Color.RED, Color.BLACK));
    }
}
}