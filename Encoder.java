// Encoder.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Encoder area that connects to other worlds.
 */
public class Encoder extends SuperWorld
{
    Text R = new Text();
    Text E = new Text();
    Text A = new Text();
    Text D = new Text();
    Computer computer = new Computer();
    Door door = new Door();
    
    public Encoder(PlayerOne player, int x, int y) {
        super(player, x, y);
        this.player = player;
        addObject(player, x, y);
        //Add Door
        addObject(door, 50, 300);
        //Add Computer
        addObject(computer, 440, 200);
        //Add Letters
        addObject(R, 350, 115);
        addObject(E, 410, 115);
        addObject(A, 470, 115);
        addObject(D, 530, 115);
        /*
        //Add all 4 keys
        addObject(new Key(), 150, 200);
        addObject(new Key(), 300, 350);
        addObject(new Key(), 450, 100);
        addObject(new Key(), 600, 250);
        */
    }
    
    private void checkDoor() {
        if (player.getKeyCount() >= 4) {
            door.unlock();
        }
    }
    
    private void letterUpdate() {
        int keys = player.getKeyCount();
        if (keys >= 1) R.setLetter("R");
        if (keys >= 2) E.setLetter("E");
        if (keys >= 3) A.setLetter("A");
        if (keys >= 4) D.setLetter("D");
    }
    
    public void act() {
        letterUpdate();
        checkBounds();
        checkDoor();
    }
    
    private void checkBounds() {
        if (player.getX() > getWidth() - 2) {
            WorldGrass4 next = new WorldGrass4(player, getWidth() - player.getX() + 7, player.getY());
            Greenfoot.setWorld(next);
        } else if (player.getY() > getHeight()-5) {
            WorldMain next = new WorldMain(player, player.getX(), getHeight()-player.getY()+4);
            Greenfoot.setWorld(next);
        }
    }
}
