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
    PlayerOne player;
    EvilRasamny rasamny;
    public BossRoom(PlayerOne player, int x, int y)
    {   
        super(player, x , y); 
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, 700, 500);
        rasamny = new EvilRasamny();
        addObject(rasamny, 100, 100);
        // Add boss and other world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
    }
}