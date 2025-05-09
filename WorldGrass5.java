// WorldGrass5.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fifth grass area world that connects to other worlds.
 */
public class WorldGrass5 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass5.
     */
    public WorldGrass5(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        player.WorldType = WORLDSTATE.GRASS;

        GreenfootImage image = new GreenfootImage("GrassWorld4-3-2.jpg");
        setBackground(image);
        

        addObject(new Frog(), 200, 200);
        addObject(new Frog(), 400, 200);
        addObject(new Frog(), 500, 100);
 
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() < 5) {
            WorldGrass4 next = new WorldGrass4(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldGrass2 next = new WorldGrass2(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        } else if(player.getX() > getWidth() - 5) {
            WorldGrass6 next = new WorldGrass6(player, 10, player.getY());
            Greenfoot.setWorld(next);
        }
    }
}