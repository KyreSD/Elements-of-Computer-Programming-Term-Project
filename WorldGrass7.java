// WorldGrass7.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Seventh grass area world that connects to other worlds.
 */
public class WorldGrass7 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass7.
     */
    public WorldGrass7(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        GreenfootImage image = new GreenfootImage("GrassWorld4-2.jpg");
        setBackground(image);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass8 next = new WorldGrass8(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            Dungeon1 next = new Dungeon1(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldGrass1 next = new WorldGrass1(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        }
    }
}