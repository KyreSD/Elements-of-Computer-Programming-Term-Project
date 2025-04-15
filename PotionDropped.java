import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * XP object dropped when an enemy is defeated.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PotionDropped extends Actor
{
    /**
     * Act - do whatever the xpDropped wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PotionDropped(){
        setImage("Potion.png");
        getImage().scale(30,30);
        System.out.println("Potion has dropped");
    }
    
    public void act()
    {
        PlayerOne player = (PlayerOne)getOneIntersectingObject(PlayerOne.class);
        if(player != null){
            SuperWorld world = (SuperWorld)getWorld();
            if(world != null){
                //world.addXP(5);
                world.removeObject(this);
            }
        }
    }
}
