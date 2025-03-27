import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArmorDropped here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArmorDropped extends Actor
{
    /**
     * Act - do whatever the ArmorDropped wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        if(placeholder != null){
            MyWorld world = (MyWorld)getWorld();
            if(world != null){
                world.addArmor(HealthSets.maxHealthP1/2);
                world.removeObject(this);
            }
        }
    }
    public ArmorDropped(){
        setImage("armor.png");
        getImage().scale(30,30);
        System.out.println("armor has dropped");
    }
}
