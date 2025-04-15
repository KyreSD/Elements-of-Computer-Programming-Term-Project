import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectBoy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectBoy extends Actor
{
    /**
     * Act - do whatever the SelectBoy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(CharacterSelection.SELECT_CH==0){
            setImage("FullSheetBoySingle.png");
        }else{
            setImage("FullSheetBoyGrey.png");
        }
    }
}
