// WorldGrass6.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sixth grass area world that connects to other worlds.
 */
public class WorldGrass6 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass6.
     */
    public WorldGrass6(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        addObject(new MountainGolem(), 400, 300);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() < 5) {
            WorldGrass5 next = new WorldGrass5(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldGrass3 next = new WorldGrass3(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
