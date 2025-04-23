import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon3 extends SuperWorld
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    public Dungeon3(PlayerOne player, int x, int y)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, x, y);
        Enemy enemy = new Enemy();
        Enemy miniBoss = new Enemy();
        addObject(enemy, 100, 50);
        addObject(miniBoss, 350, 200);
    }
    public void act(){
    if(player.getX() > getWidth()-2){
        Dungeon2 next = new Dungeon2(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() < 2){
        Dungeon4 next = new Dungeon4(player, player.getX(),getHeight()-player.getY()-2);
        Greenfoot.setWorld(next);
    }
    }
}
