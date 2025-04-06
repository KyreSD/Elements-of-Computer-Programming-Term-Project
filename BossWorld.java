/**
 * Write a description of class BossWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class BossWorld extends World {
    public BossWorld() {
        super(600, 400, 1);
        computerDesk();
        prepareWorld();
    }
    //Will Edventually have its own special background, for just blank
    private void prepareWorld() {
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.WHITE);
        bg.fill();
        setBackground(bg);
        //Add Back Button
        addObject(new BackButton(), 50,50);
    }
    private void computerDesk() {
        ComputerDesk desk = new ComputerDesk();
        addObject(desk, getWidth()/2, getHeight()/2);
    }
}
