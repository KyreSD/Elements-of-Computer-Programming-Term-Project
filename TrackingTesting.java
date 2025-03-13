import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrackingTesting here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrackingTesting extends Actor
{
    /**
     * Act - do whatever the TrackingTesting wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Placeholder placeholder;
    public TrackingTesting(){
        setImage("blob.png");
        getImage().scale(30,30);
        System.out.println("XP has dropped");
    }
    public void act()
    {
        for (Placeholder placeholder : getWorld().getObjects(Placeholder.class)){
           setLocation(placeholder.getX(),placeholder.getY()); 
        }
    }
}
