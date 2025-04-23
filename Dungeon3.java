// Dungeon3.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Third dungeon area that connects to other worlds.
 */
public class Dungeon3 extends SuperWorld
{
    /**
     * Constructor for objects of class Dungeon3.
     */
    public Dungeon3(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            Dungeon2 next = new Dungeon2(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            Dungeon4 next = new Dungeon4(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        }
    }
}
