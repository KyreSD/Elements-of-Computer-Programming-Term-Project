import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //
    }
    
    
    public void CheckHealth(int bar){
        if(bar<=100 && bar>90){
            setImage("full100.png");
        }else if(bar<=90 && bar>80){
            setImage("health90.png");
        }else if(bar<=80 && bar>70){
            setImage("health80.png");
        }else if(bar<=70 && bar>60){
            setImage("health70.png");
        }else if(bar<=60 && bar>50){
            setImage("health60.png");
        }else if(bar<=50 && bar>40){
            setImage("health50.png");
        }else if(bar<=40 && bar>30){
            setImage("health40.png");
        }else if(bar<=30 && bar>20){
            setImage("health30.png");
        }else if(bar<=20 && bar>10){
            setImage("health20.png");
        }else if(bar<=10 && bar>0){
            setImage("health10.png");
        }else if(bar<=0){
            setImage("health0.png");
        }
    }
}
