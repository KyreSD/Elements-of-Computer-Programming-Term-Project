import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldMain extends SuperWorld
{

    /**
     * Constructor for objects of class WorldOne.
     * 
     */
    public WorldMain()
    {    
        player = new PlayerOne();
        addObject(player, 300, 200);
    }
    public WorldMain(PlayerOne player, int x, int y)
    {
        this.player = player;
        addObject(player, x, y);
        Enemy enemy = new Enemy();
        addObject(enemy, 600, 400);
    }
    public void act(){
        if(player.getX() > getWidth()-2){
        WorldGrass1 next = new WorldGrass1(player, getWidth()-player.getX()+1,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getX() < 2){
        Graveyard next = new Graveyard(player, getWidth()-player.getX()-2,player.getY());
        Greenfoot.setWorld(next);
    }else if(player.getY() < 2){
        Encoder next = new Encoder(player, player.getX(),getHeight()-player.getY()-2);
        Greenfoot.setWorld(next);
    }else if(player.getY() > getHeight()-2){
        Dungeon1 next = new Dungeon1(player, player.getX(),getHeight()-player.getY()+2);
        Greenfoot.setWorld(next);
    }    
    }  
}
