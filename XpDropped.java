import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class xpDropped here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class XpDropped extends Actor
{
    /**
     * Act - do whatever the xpDropped wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public XpDropped(){
        setImage("blob.png");
        getImage().scale(30,30);
        System.out.println("XP has dropped");
    }
    public void act()
    {
        Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        Link link = (Link)getOneIntersectingObject(Link.class);
        RetroSprite retrosprite = (RetroSprite)getOneIntersectingObject(RetroSprite.class);
        if(placeholder != null){
            MyWorld world = (MyWorld)getWorld();
            if(world != null){
                world.addXP(5);
                world.removeObject(this);
            }
        }
        if(link != null){
            MyWorld world = (MyWorld)getWorld();
            if(world != null){
                world.addXP(5);
                world.removeObject(this);
            }
        }
        if(retrosprite != null){
            MyWorld world = (MyWorld)getWorld();
            if(world != null){
                world.addXP(5);
                world.removeObject(this);
            }
        }
    }
}