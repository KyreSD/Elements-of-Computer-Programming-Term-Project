import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HandLeft extends Actor
{
    /**
     * Act - do whatever the LeftHand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter;
    int change;
    Ball ball;
    
    HandLeft(){
        counter=1;
        change =1;
    }
    public void act()
    {
        counter+=1;
        if(counter % 3 == 0){
            if(getY()<234){
                
                change = 1;
            }
            if(getY()>375){
                ball = new Ball(Greenfoot.getRandomNumber(180));
                getWorld().addObject(ball, getX(), getY());
                change = -1;
            }
        }
        setLocation(getX(), getY()+change);
        setImage("RasamnyHandLeft.png");
    }
}
