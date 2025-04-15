import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlButton extends Actor
{
    /**
     * Act - do whatever the ControlsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage ctrlTxt = new GreenfootImage("ctrl.png");
        TitleScreen.selectButton();
        if(TitleScreen.SELECT == 0){
            setImage("ctrlwhite.png");
        }
        if(TitleScreen.SELECT == 1){
            setImage("ctrl.png");
        }
        if(Greenfoot.isKeyDown("enter")&&TitleScreen.SELECT==1)
        {
            Greenfoot.setWorld(new CharacterSelection());
        }
    }
}
