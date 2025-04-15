import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldGrass5 extends SuperWorld
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    public WorldGrass5(PlayerOne player, int x, int y)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, x, y);
    }
    public void act(){
    if(player.getX() < 2){
        WorldGrass4 next = new WorldGrass4(player, getWidth()-player.getX()-2,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() > getHeight()-2){
        WorldGrass2 next = new WorldGrass2(player, player.getX(),getHeight()-player.getY()+2);
        Greenfoot.setWorld(next);
    }else if(player.getX() > getWidth()-2){
        WorldGrass6 next = new WorldGrass6(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }
}
}