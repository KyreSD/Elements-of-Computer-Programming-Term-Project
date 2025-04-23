import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to access the controls/character selection screen.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlButton extends Actor
{
    private boolean isSelected = false;
    private static final String SELECTED_IMAGE = "ctrl.png";
    private static final String UNSELECTED_IMAGE = "ctrlwhite.png";
    
    /**
     * Act - do whatever the ControlsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Update selection state based on TitleScreen's selection
        isSelected = (TitleScreen.SELECT == 1);
        
        // Update image based on selection state
        if (isSelected) {
            setImage(SELECTED_IMAGE);
        } else {
            setImage(UNSELECTED_IMAGE);
        }
        
        // If this button is selected and enter is pressed, go to character selection
        if (isSelected && Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new CharacterSelection());
        }
    }
}
