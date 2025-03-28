import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FullSheetBoyImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FullSheetBoyImage extends Actor
{
    /**
     * Act - do whatever the FullSheetBoyImage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage boyImage = new GreenfootImage("FullSheetBoyGrey.png");
        if(CharacterSelection.SELECT == 0){
            setImage("FullSheetBoySingle.png");
        if(CharacterSelection.SELECT == 1){
            setImage("FullSheetBoyGrey.png");
        }
        if(Greenfoot.isKeyDown("enter")&&CharacterSelection.SELECT==0){
            Greenfoot.setWorld(new MyWorld(1, 1000000, 300, 200));
        }
    }
}
}
