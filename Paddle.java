import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("left")){
            move(-8);
        }else if(Greenfoot.isKeyDown("right")){
            move(8);
        }
    }
    
    public int getXCoordnate(){
        return getX();
    }
    
    public int getLeftEdge(){
        return getX() - getImage().getWidth()/2;
    }
    public int getRightEdge(){
        return getX() + getImage().getWidth()/2;
    }
}