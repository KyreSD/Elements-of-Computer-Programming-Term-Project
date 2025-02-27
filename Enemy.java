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
    int health = 200;
    private Placeholder placeholder;
    public void act(){   
        Sword sword = (Sword)getOneIntersectingObject(Sword.class);
        if (sword != null){
            health = health-1;
        } 
        Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        if (placeholder != null){
            if (placeholder.playerHealth > 0){
                placeholder.playerHealth = placeholder.playerHealth - 1;
                System.out.println(placeholder.playerHealth);
            } else {
                getWorld().removeObject(placeholder);
                placeholder = null;
            }
        }
        trackPlayer();
    }
    public void trackPlayer(){
        if (!getWorld().getObjects(Placeholder.class).isEmpty()){
            Placeholder placeholder = (Placeholder)getWorld().getObjects(Placeholder.class).get(0);
            turnTowards(placeholder.getX(), placeholder.getY());
            move(2);
        }
    }
    public int enemyHealth(){
        return health;
    }
}