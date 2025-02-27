import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class xpDropped here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class xpDropped extends Actor
{
    /**
     * Act - do whatever the xpDropped wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    xpPickedUp();
}
    public void xpPickedUp(){
        Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        if(intersects(placeholder)){
            MyWorld world = (MyWorld)getWorld();
            world.addXP(5);
            world.removeObject(this);
        }        
    }
}
