import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectRetro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectRetro extends Actor
{
    /**
     * Act - do whatever the SelectRetro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(CharacterSelection.SELECT_CH==2){
            setImage("RetroSpriteImage.png");
        }else{
            setImage("RetroSpriteGrey.png");
        }    
    }
}
