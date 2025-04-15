import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperWorld extends World
{
    public int xp;
    public int level;
    public int xpThreshold;
    private boolean isPaused = false;
    PlayerOne player;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public SuperWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        //weapon damage variables
        //weapons news
        Sword sword = new Sword(6, 1);
        //CooldownDisplays
        //Keeps track if paused or not

    }
    
    public void checkCombat(){
        showText("Sword Cooldown:" + PlayerOne.attackTimerSword,100, 100);
        showText("Fireball Cooldown:" + PlayerOne.attackTimerFireball, 300, 100);
    }
}
