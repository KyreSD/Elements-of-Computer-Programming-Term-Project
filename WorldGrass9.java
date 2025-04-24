// WorldGrass9.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ninth grass area world that connects to other worlds.
 */
public class WorldGrass9 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass9.
     */
    public WorldGrass9(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        addObject(new KingOrc(), 400, 300);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() < 5) {
            WorldGrass8 next = new WorldGrass8(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldGrass3 next = new WorldGrass3(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        }
    }
}