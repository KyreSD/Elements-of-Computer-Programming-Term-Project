// Graveyard.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Graveyard area that connects to other worlds.
 */
public class Graveyard extends SuperWorld
{
    /**
     * Constructor for objects of class Graveyard.
     */
    public Graveyard(PlayerOne player, int x, int y)
    {   
        super(player, x, y);
        player.WorldType = WORLDSTATE.DUNGEON;
        GreenfootImage image = new GreenfootImage("image-3.jpg");
        setBackground(image);
        

        addObject(new Skeleton(), 100, 100);
        addObject(new Skeleton(), 150, 100);
        addObject(new Skeleton(), 200, 200);
        addObject(new Skeleton(), 250, 200);
        addObject(new Skeleton(), 300, 300);
        addObject(new Skeleton(), 350, 300);
        addObject(new Skeleton(), 400, 400);
        addObject(new Skeleton(), 450, 400);
        addObject(new Skeleton(), 500, 500);
        addObject(new Skeleton(), 550, 500);
        addObject(new Skeleton(), 600, 600);

        // Add world-specific objects here
        }
    
    public void act() {
        super.act(); // Call parent act to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldMain next = new WorldMain(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } else if(player.getY() > getHeight() - 5) {
            Dungeon4 next = new Dungeon4(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}
