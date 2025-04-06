import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{   
    
    
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage theStart = new GreenfootImage("startGrey.png");
        if(TitleScreen.SELECT == 0){
            setImage("start.png");
        }
        if(TitleScreen.SELECT == 1){
            setImage("startGrey.png");
        }
        if(Greenfoot.isKeyDown("enter")&&TitleScreen.SELECT==0)
        {
            Greenfoot.setWorld(new CharacterSelection());
        }
        }
    }
