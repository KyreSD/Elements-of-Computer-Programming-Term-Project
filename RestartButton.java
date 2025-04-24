import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Actor
{
    /**
     * Act - do whatever the RestartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RestartButton(){
        GreenfootImage restart = new GreenfootImage("RestartButton.png");
        restart.scale(130, 130);
        setImage(restart);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
            Greenfoot.start();
            KingOrc.keyDroppedReset();
            KingFrog.keyDroppedReset();
            VampireLord.keyDroppedReset();
            MountainGolem.keyDroppedReset();
        }
    }
}
