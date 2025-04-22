// PotionDropped.java - Updated to add potion to player's inventory with a maximum of 5
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Potion object dropped when an enemy is defeated.
 */
public class PotionDropped extends Actor
{
    private static final int MAX_POTIONS = 5;
    
    /**
     * Create a new potion with appropriate size
     */
    public PotionDropped(){
        setImage("Potion.png");
        getImage().scale(30, 30);
        //System.out.println("Potion has dropped");
    }
    
    /**
     * Check for collision with player and add potion to inventory
     */
    public void act()
    {
        PlayerOne player = (PlayerOne)getOneIntersectingObject(PlayerOne.class);
        if(player != null){
            // Only add potion if below max count
            if (player.potionCount < MAX_POTIONS) {
                // Increase player's potion count
                player.potionCount++;
                
                // Show message about potion pickup
                SuperWorld world = (SuperWorld)getWorld();
                if(world != null){
                    world.showMessage("Potion collected! (" + player.potionCount + "/" + MAX_POTIONS + ")");
                }
            } else {
                // Player already has max potions
                SuperWorld world = (SuperWorld)getWorld();
                if(world != null){
                    world.showMessage("Can't carry more potions! (Max: " + MAX_POTIONS + ")");
                }
            }
            
            // Remove potion from world
            getWorld().removeObject(this);
        }
    }
}
