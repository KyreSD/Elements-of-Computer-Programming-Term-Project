import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 100;
    public boolean doesNoDamage(Actor weapon){
        return weapon.getX() == 300 && weapon.getY() == 375;
    }
public void act()
    {       
    Sword sword = (Sword)getOneIntersectingObject(Sword.class);
        if (sword != null && !doesNoDamage(sword)){
        health = health-1;
        } 
        
    Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
    if (placeholder != null){
        placeholder.playerHealth = placeholder.playerHealth - 1;
        if(placeholder.playerHealth >= 0){
        getWorld().removeObject(placeholder);
        }
        
    }
    
    trackPlayer();
}

public void trackPlayer(){
    java.util.List actors = getWorld().getObjects(Actor.class);
    if (! actors.isEmpty())
{
    Actor actor = (Placeholder)actors.get(0);
    turnTowards(actor.getX(), actor.getY());
    move(3);
    // setRotation(0);
}
}


public int enemyHealth(){
    return health;
}
}