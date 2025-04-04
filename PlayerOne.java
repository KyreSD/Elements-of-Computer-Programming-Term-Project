import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    private int health = 3;
    private int speed = 3;
    private boolean attacking = false;
    private int attackCooldown = 0;
    
    public void act() {
        movePlayer();
        attack();
    }

    private void movePlayer() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
    }

    private void attack() {
        if (attackCooldown > 0) {
            attackCooldown--;
        }
        if (Greenfoot.isKeyDown("space") && attackCooldown == 0) {
            MasterSword sword = new MasterSword();
            getWorld().addObject(sword, getX(), getY());
            attackCooldown = 30; // Cooldown for attack
        }
    }
}
