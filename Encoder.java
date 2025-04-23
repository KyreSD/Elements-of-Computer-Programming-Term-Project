import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Encoder extends SuperWorld
{
    /**
     * Constructor for objects of class World2.
     * 
     */
    Text text1;
    Text text2;
    Text text3;
    Text text4;
    public Encoder(PlayerOne player, int x, int y)
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        this.player = player;
        addObject(player, x, y);
        text1 = new Text(0);
        text2 = new Text(0);
        text3 = new Text(0);
        text4 = new Text(0);
        addObject(text1, 270, 135);
        addObject(text2, 300, 135);
        addObject(text3, 330, 135);
        addObject(text4, 360, 135);
    }
    public void act(){  
        if(player.getX() > getWidth()-2){
        WorldGrass4 next = new WorldGrass4(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() > getHeight()-2){
        WorldMain next = new WorldMain(player, player.getX(),getHeight()-player.getY()+2);
        Greenfoot.setWorld(next);
    }
    }
}
