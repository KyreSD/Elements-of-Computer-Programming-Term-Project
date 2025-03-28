import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class linkImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LinkImage extends Actor
{
    /**
     * Act - do whatever the linkImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage link = new GreenfootImage("linkSpritSingle.png");
        CharacterSelection.pickCharacter();
        if(CharacterSelection.SELECT == 0){
            setImage("linkSpriteGrey.png");
        } else{
            setImage("linkSpriteSingle.png");
        }
        if(Greenfoot.isKeyDown("enter")&&CharacterSelection.SELECT==1){
            Greenfoot.setWorld(new MyWorld(1, 1000000, 300, 200));
        }
    }
}
