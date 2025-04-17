import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int counter;
    public Text(int counter){
        counter = 0;
        
    }
    public void act()
    { 
        counter += 1;
        if(counter % 6 ==0 ){
        int x = Greenfoot.getRandomNumber(69)+30;
        char c = (char) x;
        String s = String.valueOf(c);
        setImage(new GreenfootImage(s, 54, Color.WHITE, Color.BLACK));
    }
    }
}
