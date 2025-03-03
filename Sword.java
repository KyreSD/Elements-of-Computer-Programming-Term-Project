import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
    if (enemy != null){
        enemy.health = enemy.health - 1;
        enemy.checkHealth();
        }
    if (Greenfoot.isKeyDown("up")){
        setRotation(270);
    }
    if (Greenfoot.isKeyDown("down")){
        setRotation(90);
    }
    if (Greenfoot.isKeyDown("left")){
        setRotation(180);
    }
    if (Greenfoot.isKeyDown("right")){
        setRotation(0);
    }
    }
    
}
