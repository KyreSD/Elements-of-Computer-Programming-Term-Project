/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class Door extends Actor  
{
    private boolean isLocked = true;
    private GreenfootImage closedDoor = new GreenfootImage("closeddoor.png");
    private GreenfootImage openDoor = new GreenfootImage("opendoor.png");
    private int width = 60;
    private int height = 80;
    
    public Door() {
        closedDoor = new GreenfootImage("closeddoor.png");
        openDoor = new GreenfootImage("opendoor.png");
        
        closedDoor.scale(width, height);
        openDoor.scale(width, height);
        
        //starting state
        setImage(closedDoor);
    }
    
    public void act() {
        if (!isLocked) {
            PlayerOne player = (PlayerOne)getOneIntersectingObject(PlayerOne.class);
            if (player != null) {
                BossRoom bossRoom = new BossRoom(player, 700, 300);
                Greenfoot.setWorld(bossRoom);
            }
        }
    }
    
    public void unlock() {
        if (isLocked) {
            isLocked = false;
            setImage(openDoor);
        }
    }
    
    public boolean isLocked() {
        return isLocked;
    }
}
