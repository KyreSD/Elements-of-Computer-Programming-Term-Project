// Dungeon1.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First dungeon area that connects to other worlds.
 */
public class Dungeon1 extends SuperWorld
{
    /**
     * Constructor for objects of class Dungeon1.
     */
    public Dungeon1(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass7 next = new WorldGrass7(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getX() < 5) {
            Dungeon4 next = new Dungeon4(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldMain next = new WorldMain(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            Dungeon2 next = new Dungeon2(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
