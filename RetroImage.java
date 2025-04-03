import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RetroSpritGrey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RetroImage extends Actor
{
    /**
     * Act - do whatever the RetroSpritGrey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        CharacterSelection.pickCharacter();
        if(CharacterSelection.SELECT == 2){
            setImage("RetroSpriteImage.png");
            getImage().scale(80,80);
        }else{
            setImage("RetroSpriteGrey.png");
            getImage().scale(80,80);
        }
        
        if(Greenfoot.isKeyDown("enter")&&CharacterSelection.SELECT == 2){
            Greenfoot.setWorld(new MyWorld(CharacterSelection.getSelectedCharacter(), 1, 1000000, 300, 200));
        }
}
}
