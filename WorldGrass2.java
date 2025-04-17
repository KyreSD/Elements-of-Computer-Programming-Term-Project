import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldGrass2 extends SuperWorld
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    public WorldGrass2(PlayerOne player, int x, int y)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, x, y);
        Enemy enemy = new Enemy();
        Enemy enemy2 = new Enemy();
        Enemy enemy3 = new Enemy();
        addObject(enemy, 400, 50);
        addObject(enemy2, 600, 450);
    }
    public void act(){
        if(player.getX() > getWidth()-2){
        WorldGrass3 next = new WorldGrass3(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getX() < 2){
        WorldGrass1 next = new WorldGrass1(player, getWidth()-player.getX()-2,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() < 2){
        WorldGrass5 next = new WorldGrass5(player, player.getX(),getHeight()-player.getY()-2);
        Greenfoot.setWorld(next);
    }else if(player.getY() > getHeight()-2){
        WorldGrass8 next = new WorldGrass8(player, player.getX(),getHeight()-player.getY()+2);
        Greenfoot.setWorld(next);
    }
        
    }
}