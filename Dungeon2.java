// Dungeon2.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second dungeon area that connects to other worlds.
 */
public class Dungeon2 extends SuperWorld
{
    /**
     * Constructor for objects of class Dungeon2.
     */
    public Dungeon2(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        GreenfootImage image = new GreenfootImage("image-4.png");
        setBackground(image);
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() < 5) {
            Dungeon3 next = new Dungeon3(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            Dungeon1 next = new Dungeon1(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        }
    }
}
