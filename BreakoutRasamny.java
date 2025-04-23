import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BreakoutRasamny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakoutRasamny extends Enemy
{
    /**
     * Act - do whatever the BreakoutRasamny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    PlayerOne player;
    BreakoutRasamny(PlayerOne player){
        health = 2000;
        this.player = player;
    }
    public void act()
    {
        setImage("BreakoutRasamnyq.png");
        super.checkCombat();
    if (damageDelay > 0) {
            damageDelay--;
    }
    Ball ball = (Ball)getOneIntersectingObject(Ball.class);
    if (ball != null){
        health -= 20;
    }
    if(health <= 0){
        if(health<=0){
        BossRoom next = new BossRoom(player, 500, 500);
        getWorld().removeObject(this);
        Greenfoot.setWorld(next);
    }
    }
}
}
