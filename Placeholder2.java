import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Placeholder2 extends Actor
{
    private int attackTimerSword = 0;
    private int attackTimerFireball = 0;

    public Placeholder2(String sprite, int rows, int cols) {
        setImage(new GreenfootImage(sprite));
    }

    public void act() {
        attackTimerSword = Math.max(0, attackTimerSword - 1);
        attackTimerFireball = Math.max(0, attackTimerFireball - 1);
        checkKeys();
    }

    private void checkKeys() {
        if (Greenfoot.isKeyDown("space") && attackTimerSword == 0) {
            attackTimerSword = 30;  // Cooldown in frames
            getWorld().addObject(new Sword2(), getX(), getY());
        }
    }

    public int getAttackTimerSword() {
        return attackTimerSword;
    }

    public int getAttackTimerFireball() {
        return attackTimerFireball;
    }
    
    private void spawnSword(int x, int y) {
        if (sword == null) {
            sword = new Sword(6,1);
            getWorld().addObject(sword, x, y);
            attackTimerSword = timerSword;
        }
    }
    private void spawnFireball(int x, int y) {
        if (fireball == null) {
            fireball = new Fireball();
            getWorld().addObject(fireball, x, y);
            attackTimerFireball = timerFireball;
        }
    }
}
