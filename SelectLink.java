import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectLink here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectLink extends Actor
{
    /**
     * Act - do whatever the SelectLink wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        CharacterSelection.pickCharacter();
        if(CharacterSelection.SELECT_CH==1){
            setImage("linkSpriteSingle.png");
        }else{
            setImage("linkSpriteGrey.png");
        }
    }
}
