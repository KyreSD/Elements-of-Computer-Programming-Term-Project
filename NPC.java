/**
 * Write a description of class NPC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class NPC extends Actor {
    private int currentMessage = 0;
    private boolean interactionPossible = false;
    private boolean isTalking = false;
    // The messages that the npc can say
    private String[] messages = {"This is a test for the current NPC",
    "Future Tutorial Dialogue to be added"};
    
    public NPC() {
        setImage("npc.png"); // image for the npc
        getImage().scale(50,75); // image sizer
    }
    
    public void act() {
        checkPlayerNearby();
        showNPCMessage();
        interaction();
    }
    
    private void checkPlayerNearby() {
        // Check distance to NPC
        Actor player = getOneIntersectingObject(Placeholder.class);
        interactionPossible = (player != null);
    }
    
    private void showNPCMessage() {
        if (interactionPossible && !isTalking) {
            GreenfootImage prompt = new GreenfootImage("Press E to Talk", 16,
            Color.BLACK, null);
            getWorld().getBackground().drawImage(prompt, getX() - prompt.getWidth()/2,
            getY() - 60);
        } else {
            getWorld().showText("", getX(), getY() - 60);
        }
    }
    
    private void interaction() {
        if (interactionPossible && Greenfoot.isKeyDown("e") && !isTalking) {
            isTalking = true;
            showMessage();
        }
        
        if (isTalking && Greenfoot.mouseClicked(null)) {
            nextMessage();
        }
    }
    
    private void showMessage() {
        GreenfootImage message = new GreenfootImage(messages[currentMessage], 16,
        Color.BLACK, null);
        getWorld().getBackground().drawImage(message, getX() - message.getWidth()/2,
        getY() - 90);
    }
    
    private void nextMessage() {
        currentMessage++;
        if (currentMessage >= messages.length) {
            conversationOver();
        } else {
            showMessage();
        }
    }
    
    private void conversationOver() {
        isTalking = false;
        currentMessage = 0;
        getWorld().showText("", getX(), getY() - 60);
    }
}
