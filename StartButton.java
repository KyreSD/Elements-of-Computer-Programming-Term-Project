import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to start the game from the title screen.
 */
public class StartButton extends Actor
{
    private boolean isSelected = true;
    
    public StartButton() {
        updateImage();
    }
    
    /**
     * Act method - handle selection and clicks
     */
    public void act() 
    {
        // Update selection based on title screen selection
        isSelected = (TitleScreen.SELECT == 0);
        updateImage();
        
        // Handle click or enter key to start game
        if (isSelected && (Greenfoot.isKeyDown("enter"))) {
            // Reset any existing player when starting fresh from title screen
            CharacterSelection.setExistingPlayer(null);
            
            // Go to character selection
            Greenfoot.setWorld(new CharacterSelection());
        }
    }
    
    /**
     * Update button appearance based on selection state
     */
    private void updateImage() {
        if(isSelected){
            GreenfootImage image = new GreenfootImage("start.png");
            setImage(image);
        }else{
            setImage("startGrey.png");
        }
    }
}
