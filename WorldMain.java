// WorldMain.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main starting world of the game.
 */
public class WorldMain extends SuperWorld
{
    /**
     * Constructor for objects of class WorldMain.
     */
    public WorldMain(PlayerOne player, int x, int y) {
        super(player, x, y);
        
        // Add enemy only in this constructor
        Enemy enemy = new Enemy();
        //addObject(enemy, 600, 400)
    }
    
    /**
     * Handle world transitions based on player position
     */
    public void act() {
        super.act(); // Important to call super.act() to maintain UI and game logic
        
        if(player.getX() > getWidth() - 5) {
            WorldGrass1 next = new WorldGrass1(player, 10, player.getY());
            Greenfoot.setWorld(next);
        } 
        else if(player.getX() < 5) {
            Graveyard next = new Graveyard(player, getWidth() - 10, player.getY());
            Greenfoot.setWorld(next);
        } 
        else if(player.getY() < 5) {
            Encoder next = new Encoder(player, player.getX(), getHeight()-10);
            Greenfoot.setWorld(next);
        } 
        else if(player.getY() > getHeight() - 5) {
            Dungeon1 next = new Dungeon1(player, player.getX(), 10);
            Greenfoot.setWorld(next);
        }
    }
}