// WorldGrass8.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eighth grass area world that connects to other worlds.
 */
public class WorldGrass8 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass8.
     */
    public WorldGrass8(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        player.WorldType = WORLDSTATE.GRASS;
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass9 next = new WorldGrass9(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            WorldGrass7 next = new WorldGrass7(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldGrass2 next = new WorldGrass2(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        }
    }
}