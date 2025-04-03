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
        GreenfootImage link = new GreenfootImage("linkSpriteSingle.png");
        CharacterSelection.pickCharacter();
        if(CharacterSelection.SELECT == 1){
            setImage("linkSpriteSingle.png");
            getImage().scale(80,80);
        } else{
            setImage("linkSpriteGrey.png");
            getImage().scale(80,80);
        }
        if(Greenfoot.isKeyDown("enter")&&CharacterSelection.SELECT == 1){
            Greenfoot.setWorld(new MyWorld(CharacterSelection.getSelectedCharacter(), 1, 1000000, 300, 200));
        }
    }
}
