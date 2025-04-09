import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ganon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ganon extends Actor
{
    /**
     * Act - do whatever the Ganon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int health = 2;
    private int speed = 1;

    public void act() {
        followPlayer();
    }

    private void followPlayer() {
        Placeholder player = (Placeholder) getWorld().getObjects(Placeholder.class).get(0);
        turnTowards(player.getX(), player.getY());
        move(speed);
    }

    public void takeDamage() {
        health--;
        if (health <= 0) {
            getWorld().removeObject(this);
        }
    }
}
