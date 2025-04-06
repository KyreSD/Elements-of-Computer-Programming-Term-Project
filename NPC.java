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
    //Current text actor 
    private Actor currentTextBubble = null;
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
            clearText();
            currentTextBubble = new TextActor("Press E to Talk", 16, Color.BLACK,
            new Color(255, 255, 255, 200));
            getWorld().addObject(currentTextBubble, getX(), getY() - 60);
        } else if (!interactionPossible && !isTalking) {
            clearText();
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
        clearText();
        currentTextBubble = new TextActor(messages[currentMessage], 16, Color.BLACK,
        new Color(255, 255, 255, 200));
        getWorld().addObject(currentTextBubble, getX(), getY() - 90);
    }
    
    private void clearText() {
        if (currentTextBubble != null) {
            getWorld().removeObject(currentTextBubble);
            currentTextBubble = null;
        }
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
    
    //Displays the text as an Actor to remove it easily
    class TextActor extends Actor {
        public TextActor(String text, int size, Color textColor, Color bgColor) {
            GreenfootImage textImage = new GreenfootImage(text, size, textColor, bgColor);
            setImage(textImage);
        }
    }
}
