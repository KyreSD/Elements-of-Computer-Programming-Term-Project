// Dungeon4.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fourth dungeon area that connects to other worlds.
 */
public class Dungeon4 extends SuperWorld
{
    /**
     * Constructor for objects of class Dungeon4.
     */
    public Dungeon4(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            Dungeon1 next = new Dungeon1(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            Graveyard next = new Graveyard(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            Dungeon3 next = new Dungeon3(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
