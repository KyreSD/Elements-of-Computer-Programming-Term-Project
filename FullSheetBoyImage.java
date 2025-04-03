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
    public FullSheetBoyImage(){
    GreenfootImage image = new GreenfootImage("FullSheetBoySingle.png");
    getImage().scale(30,30);
}
    public void act()
    {
        CharacterSelection.pickCharacter();
        if(CharacterSelection.SELECT == 0){
            setImage("FullSheetBoySingle.png");
            new Placeholder("FullSheetBoy.png" , 4, 5);
            getImage().scale(80,80);
        }else{
            setImage("FullSheetBoyGrey.png");
            getImage().scale(80,80);
        }
        
        if(Greenfoot.isKeyDown("enter")&&CharacterSelection.SELECT==0){
            Greenfoot.setWorld(new MyWorld(1, 1000000, 300, 200));
        }
    }
}
