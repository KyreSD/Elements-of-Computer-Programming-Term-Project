// BossRoom.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boss Room area that connects to other worlds.
 */
public class BossRoom extends SuperWorld
{
    /**
     * Constructor for objects of class BossRoom.
     */
    public BossRoom(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add boss and other world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            Encoder next = new Encoder(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            Graveyard next = new Graveyard(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
