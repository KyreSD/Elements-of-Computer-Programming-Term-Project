// Graveyard.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Graveyard area that connects to other worlds.
 */
public class Graveyard extends SuperWorld
{
    /**
     * Constructor for objects of class Graveyard.
     */
    public Graveyard(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
        }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldMain next = new WorldMain(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            Dungeon4 next = new Dungeon4(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
