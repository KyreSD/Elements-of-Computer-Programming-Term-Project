import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyTracking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class EnemyTracking extends Actor
{
    /**
     * Act - do whatever the EnemyTracking wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health;
    private Placeholder placeholder;
    public void act(){
        trackPlayer();
        //System.out.println("Tracker health: " + health);
    }

    public void trackPlayer(){
        if (!getWorld().getObjects(Placeholder.class).isEmpty()){
            Placeholder placeholder = (Placeholder)getWorld().getObjects(Placeholder.class).get(0);
            turnTowards(placeholder.getX(), placeholder.getY());
            move(2);
        }
        if (!getWorld().getObjects(Link.class).isEmpty()){
            Link link = (Link)getWorld().getObjects(Link.class).get(0);
            turnTowards(link.getX(), link.getY());
            move(2);
        }
        if (!getWorld().getObjects(RetroSprite.class).isEmpty()){
            RetroSprite retro = (RetroSprite)getWorld().getObjects(RetroSprite.class).get(0);
            turnTowards(retro.getX(), retro.getY());
            move(2);
        }
    }
}
