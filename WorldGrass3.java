// WorldGrass3.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Third grass area world that connects to other worlds.
 */
public class WorldGrass3 extends SuperWorld
{
    /**
     * Constructor for objects of class WorldGrass3.
     */
    public WorldGrass3(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        player.WorldType = WORLDSTATE.GRASS;
        GreenfootImage image = new GreenfootImage("GrassWorld3-4.jpg");
        setBackground(image);
        

        addObject(new Orc(), 100, 200);
        addObject(new Orc(), 200, 100);
        addObject(new Orc(), 300, 200);
        addObject(new Orc(), 400, 100);
        addObject(new Orc(), 500, 200);
        // Add world-specific objects here
    }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() < 5) {
            WorldGrass2 next = new WorldGrass2(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() < 5) {
            WorldGrass6 next = new WorldGrass6(player, player.getX(), getHeight() - 10);
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            WorldGrass9 next = new WorldGrass9(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}