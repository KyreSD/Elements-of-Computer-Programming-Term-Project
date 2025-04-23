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
    
    BreakoutRasamny(){
        health = 2000;
    }
    public void act()
    {
        setImage("BreakoutRasamnyq.png");
        super.checkCombat();
    if (damageDelay > 0) {
            damageDelay--;
    }
        if(health<=0){
        BossRoom next = new BossRoom();
        Greenfoot.setWorld(next);
    }
    Ball ball = (Ball)getOneIntersectingObject(Ball.class);
    if (ball != null){
        health -= 20;
    }
}
}
