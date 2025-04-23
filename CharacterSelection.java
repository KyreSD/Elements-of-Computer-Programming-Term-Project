import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Character selection screen that allows the player to choose their character.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CharacterSelection extends World
{
    public static int SELECT_CH = 1;
    private Actor[] characters = new Actor[3]; // Using array to store 3 characters
    private String[] characterNames = {"Boy", "Link", "Retro"};
    
    // Store previous player instance if coming back to selection screen
    private static PlayerOne existingPlayer = null;
    
    /**
     * Constructor for objects of class CharacterSelection.
     */
    public CharacterSelection()
    {    
        super(800, 600, 1); // Matching the size of other worlds
        
        characters[0] = new SelectBoy();
        characters[1] = new SelectLink();
        characters[2] = new SelectRetro();
        
        showText("Choose Your Character", getWidth()/2, 100);
        showText("Use arrow keys to navigate, space to select", getWidth()/2, 150);
        
        // Position characters evenly across the screen
        addObject(characters[0], getWidth()/4, 300);
        addObject(characters[1], getWidth()/2, 300);
        addObject(characters[2], 3*getWidth()/4, 300);
        
        // Highlight the initially selected character
        updateSelection();
    }
    
    /**
     * Constructor with existing player (for when returning from a game world).
     */
    public CharacterSelection(PlayerOne player)
    {
        this();
        existingPlayer = player;
    }
    
    public void act() {
        handleInput();
        updateSelection();
    }
    
    /**
     * Handle keyboard input for character selection
     */
    private void handleInput() {
        // Move selection right
        if(Greenfoot.isKeyDown("right") && SELECT_CH < 2) {  
            SELECT_CH += 1;
            Greenfoot.delay(10); // Prevent too rapid selection
        }
        
        // Move selection left
        if(Greenfoot.isKeyDown("left") && SELECT_CH > 0) {
            SELECT_CH -= 1;
            Greenfoot.delay(10);
        }
        
        // Select character and start game
        if(Greenfoot.isKeyDown("space")) {
            PlayerOne selectedPlayer;
            
            // Either update existing player or create a new one
            if (existingPlayer != null) {
                selectedPlayer = existingPlayer;
                // Update the character type which handles all visual changes
                selectedPlayer.setCharacterType(SELECT_CH);
            } else {
                // Create the appropriate player based on selection
                if (SELECT_CH == 0) {
                    selectedPlayer = new PlayerOne(0, 4, 5); // Boy
                } else if (SELECT_CH == 1) {
                    selectedPlayer = new PlayerOne(); // Link (default)
                } else if (SELECT_CH == 2) {
                    selectedPlayer = new PlayerOne(2, 4, 4); // Retro
                } else {
                    selectedPlayer = new PlayerOne(); // Fallback to default
                }
            }
            
            // Start the game with the selected player
            WorldMain firstWorld = new WorldMain(selectedPlayer, getWidth()/2, getHeight()/2);
            Greenfoot.setWorld(firstWorld);
        }
    }
    
    /**
     * Update visual indicators for the currently selected character
     */
    private void updateSelection() {
        // Update character highlighting
        for (int i = 0; i < characters.length; i++) {
            // Highlight selected character by adding a marker or effect
            if (i == SELECT_CH) {
                // Show selection indicator (e.g., name with highlight)
                showText(characterNames[i] + " ✓", 
                        (i == 0) ? getWidth()/4 : (i == 1) ? getWidth()/2 : 3*getWidth()/4, 
                        350);
            } else {
                // Show normal name without highlight
                showText(characterNames[i], 
                        (i == 0) ? getWidth()/4 : (i == 1) ? getWidth()/2 : 3*getWidth()/4, 
                        350);
            }
        }
    }
    
    /**
     * Static method to get the existing player if available
     */
    public static PlayerOne getExistingPlayer() {
        return existingPlayer;
    }
    
    /**
     * Static method to set the existing player
     */
    public static void setExistingPlayer(PlayerOne player) {
        existingPlayer = player;
    }
}
