import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HandRight extends Actor
{
    /**
     * Act - do whatever the RightHand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter;
    int change;
    Ball ball;
    
    HandRight(){
        counter=1;
        change =0;
    }
    public void act()
    {
        counter+=1;
        if(counter % 3 == 0 && !(counter < 150)){
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
        setImage("RasamnyHandRight.png");   
    }
}
