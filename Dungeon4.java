import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dungeon4 extends SuperWorld
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    public Dungeon4(PlayerOne player, int x, int y)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, x, y);
    }
    public void act(){
        if(player.getX() > getWidth()-2){
        Dungeon1 next = new Dungeon1(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() < 2){
        Graveyard next = new Graveyard(player, player.getX(),getHeight()-player.getY()-2);
        Greenfoot.setWorld(next);
    }else if(player.getY() > getHeight()-2){
        Dungeon3 next = new Dungeon3(player, player.getX(),getHeight()-player.getY()+2);
        Greenfoot.setWorld(next);
    }
    }
}
