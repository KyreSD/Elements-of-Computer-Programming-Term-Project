// Encoder.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Encoder area that connects to other worlds.
 */
public class Encoder extends SuperWorld
{
    /**
     * Constructor for objects of class Encoder.
     */
    public Encoder(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass4 next = new WorldGrass4(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            BossRoom next = new BossRoom(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldMain next = new WorldMain(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}