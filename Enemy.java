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
    public int X;
    public int Y;
    int health = 100;
public void act()
    {   
        X = getX();
        Y= getY();
        
    Sword sword = (Sword)getOneIntersectingObject(Sword.class);
        if (sword != null){
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
    checkHealth();
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
public void checkHealth(){
    if (health <= 0){
        dropXp();
        getWorld().removeObject(this);
    }
}

public void dropXp(){
    MyWorld world = (MyWorld)getWorld();
    world.addObject(new XpDropped(), X, Y);
    }
}
