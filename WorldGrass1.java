// WorldGrass1.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First grass area world that connects to other worlds.
 */
public class WorldGrass1 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass1.
     */
    public WorldGrass1(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        addObject(new Frog(), 100, 100);
        addObject(new Frog(), 200, 100);
        addObject(new Frog(), 300, 100);
        addObject(new Frog(), 400, 100);
        addObject(new Frog(), 500, 100);
        // Add any world-specific objects here
    }
    
    /**
     * Handle world transitions based on player position
     */
    public void act() {
        super.act(); // Important to call super.act() to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass2 next = new WorldGrass2(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } 
        else if(player.getX() < 5) {
            WorldMain next = new WorldMain(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } 
        else if(player.getY() < 5) {
            WorldGrass4 next = new WorldGrass4(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        } 
        else if(player.getY() > getHeight() - 5) {
            WorldGrass7 next = new WorldGrass7(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
