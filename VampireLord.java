import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KingOrc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class VampireLord extends Monster  
{
    private static boolean keyDropped = false;
    
    public static void keyDroppedReset() {
        keyDropped = false;
    }
    public VampireLord() {
        super();
        this.miniBoss = true;
        this.keyNotDropped = !keyDropped;
        //Monsters stas
        health = 300;
        maxHealth = 300;
        damage = 20;
        speed = 1;
        
        
        downAnimation = new GifImage("VampireLordDown.gif");
        leftAnimation = new GifImage("VampireLordLeft.gif");
        rightAnimation = new GifImage("VampireLordRight.gif");
        upAnimation = new GifImage("VampireLordUp.gif");
        attackAnimation = new GifImage("VampireLordAttack.gif");
        
        //Monster Scale Modifer
        int gifScale = 300;
        //Functions for the gif Scale Modifier 
        for (GreenfootImage image : downAnimation.getImages()) {
            int wide = image.getWidth()*gifScale/100;
            int high = image.getHeight()*gifScale/100;
            image.scale(wide,high);
        }
        for (GreenfootImage image : leftAnimation.getImages()) {
            int wide = image.getWidth()*gifScale/100;
            int high = image.getHeight()*gifScale/100;
            image.scale(wide,high);
        }
        for (GreenfootImage image : rightAnimation.getImages()) {
            int wide = image.getWidth()*gifScale/100;
            int high = image.getHeight()*gifScale/100;
            image.scale(wide,high);
        }
        for (GreenfootImage image : upAnimation.getImages()) {
            int wide = image.getWidth()*gifScale/100;
            int high = image.getHeight()*gifScale/100;
            image.scale(wide,high);
        }
        for (GreenfootImage image : attackAnimation.getImages()) {
            int wide = image.getWidth()*gifScale/100;
            int high = image.getHeight()*gifScale/100;
            image.scale(wide,high);
        }
    }
    
    public void checkHealth() {
        if (health <= 0) {
            if (miniBoss && keyNotDropped && !keyDropped) {
                dropKey();
                keyDropped = true;
            }
            //takes care of xp and monster removal 
            super.checkHealth(); 
        }
    }
    
    public void act() {
        //Inherits Monster and Enemy functions
        super.act(); 
        
        //attack animation handling
        
    }
}
