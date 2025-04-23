// XpDropped.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * XP object dropped when an enemy is defeated.
 */
public class XpDropped extends Actor
{
    private static final int XP_VALUE = 20;
    
    public XpDropped(){
        setImage("blob.png");
        getImage().scale(30,30);
        //System.out.println("XP has dropped");
    }
    
    public void act()
    {
        PlayerOne player = (PlayerOne)getOneIntersectingObject(PlayerOne.class);
        if(player != null){
            // Add 20 XP to player
            player.addXp(XP_VALUE);
            
            // Show message about XP pickup
            SuperWorld world = (SuperWorld)getWorld();
            if(world != null){
                world.showMessage("XP gained: " + XP_VALUE + " (" + player.getxp() + "/100)");
                world.removeObject(this);
            }
        }
    }
}
