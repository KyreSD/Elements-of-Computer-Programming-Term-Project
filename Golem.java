import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Orc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class Golem extends Monster  
{
    public Golem() {
        //Monsters stas
        health = 100;
        maxHealth = 100;
        damage = 5;
        speed = 1;
        miniBoss = false;
        
        downAnimation = new GifImage("GolemDown.gif");
        leftAnimation = new GifImage("GolemLeft.gif");
        rightAnimation = new GifImage("GolemRight.gif");
        upAnimation = new GifImage("GolemUp.gif");
        attackAnimation = new GifImage("GolemAttack.gif");
        
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