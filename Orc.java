import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class Orc extends Monster  
{
    public Orc() {
        //Monsters stas
        health = 80;
        maxHealth = 80;
        damage = 10;
        speed = 1;
        miniBoss = false;
        
        downAnimation = new GifImage("OrcDown.gif");
        leftAnimation = new GifImage("OrcLeft.gif");
        rightAnimation = new GifImage("OrcRight.gif");
        upAnimation = new GifImage("OrcUp.gif");
        attackAnimation = new GifImage("OrcAttack.gif");
        
        //Monster Scale Modifer
        int gifScale = 200;
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
    
    public void act() {
        //Inherits Monster and Enemy functions
        super.act(); 
        
        //attack animation handling
        
    }
}