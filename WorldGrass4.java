// WorldGrass4.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fourth grass area world that connects to other worlds.
 */
public class WorldGrass4 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass4.
     */
    public WorldGrass4(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        player.WorldType = WORLDSTATE.GRASS;
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass5 next = new WorldGrass5(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            Encoder next = new Encoder(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldGrass1 next = new WorldGrass1(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}