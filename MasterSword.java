import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MasterSword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MasterSword extends Actor
{
    /**
     * Act - do whatever the MasterSword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int duration = 15; // Duration the sword stays visible

    public MasterSword() {
        setImage("sword.png"); // Add a sprite for the sword
    }

    public void act() {
        duration--;
        if (duration <= 0) {
            getWorld().removeObject(this);
        } else {
            checkHit();
        }
    }

    private void checkHit() {
        Ganon enemy = (Ganon) getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            enemy.takeDamage();
        }
    }
}
