// WorldGrass2.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second grass area world that connects to other worlds.
 */
public class WorldGrass2 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass2.
     */
    public WorldGrass2(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass3 next = new WorldGrass3(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            WorldGrass1 next = new WorldGrass1(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldGrass5 next = new WorldGrass5(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldGrass8 next = new WorldGrass8(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}