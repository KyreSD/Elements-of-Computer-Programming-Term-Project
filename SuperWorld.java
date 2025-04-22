import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main game world that handles game logic, UI and player initialization.
 * This is the parent class for all game worlds.
 */
public class SuperWorld extends World
{
    protected PlayerOne player;
    private PlayerUI playerUI;
    private PlayerHealthBar healthBar;
    private boolean isPaused = false;
    private String currentMessage = "";
    private int messageTimer = 0;
    private static final int MESSAGE_DURATION = 300;
    
    /**
     * Constructor for objects of class SuperWorld with player position.
     */
    public SuperWorld(PlayerOne player, int x, int y) {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        this.player = player;
        
        // Add the existing player to the world at the specified position
        addObject(player, x, y);
        
        // Setup UI elements
        prepareUI();
        updateUIReferences();
    }
    
    private void prepareUI() {
        // Create health bar if it doesn't exist
        healthBar = new PlayerHealthBar(player);
        addObject(healthBar, 280, 35); // Move slightly to the left
        
        // Create UI with the player reference
        playerUI = new PlayerUI(player);
        addObject(playerUI, 120, 60); // Position under the health bar
    }
    
    /**
     * Act method called on each frame - update game state
     */
    public void act() {
        if (!isPaused) {
            checkLevelProgression();
            
            // Update message timer
            if (messageTimer > 0) {
                messageTimer--;
                if (messageTimer == 0) {
                    // Clear the message when timer reaches zero
                    showText("", getWidth()/2, getHeight() - 50);
                    currentMessage = "";
                }
            }
        }
    }
    
    /**
     * Check if player has enough XP to level up
     */
    private void checkLevelProgression() {
        // Fixed XP requirement of 100 for each level
        int xpNeeded = 100;
        
        // Check if player can level up
        if (player.getxp() >= xpNeeded) {
            levelUp();
        }
    }
    
    /**
     * Level up the player and apply benefits
     */
    private void levelUp() {
        // Increase player level
        player.level++;
        
        // Subtract the fixed XP requirement (100)
        player.xp -= 100;
        
        // Increase max health
        player.maxHealth += 25;
        player.health = player.maxHealth; // Restore health on level up
        
        // Show level up message
        showMessage("Level Up! Now level " + player.level);
    }
    
    /**
     * Display a temporary message on screen for 5 seconds
     */
    public void showMessage(String message) {
        currentMessage = message;
        messageTimer = MESSAGE_DURATION;
        showText(message, getWidth()/2, getHeight() - 50);
    }
    
    /**
     * Toggle pause state
     */
    public void togglePause() {
        isPaused = !isPaused;
        if (isPaused) {
            showText("PAUSED", getWidth()/2, getHeight()/2);
        } else {
            showText("", getWidth()/2, getHeight()/2);
        }
    }
    
    /**
     * Return to character selection screen while maintaining player instance
     */
    public void returnToCharacterSelect() {
        // Remove player from current world first
        removeObject(player);
        
        // Save player instance to static variable in CharacterSelection
        CharacterSelection.setExistingPlayer(player);
        
        // Create new character selection screen with existing player
        CharacterSelection selectionScreen = new CharacterSelection(player);
        Greenfoot.setWorld(selectionScreen);
    }
    
    /**
     * Get the player instance
     */
    public PlayerOne getPlayer() {
        return player;
    }
    
    public void updateUIReferences() {
        if (healthBar != null) {
            healthBar.setPlayer(player);
        }
        
        if (playerUI != null) {
            playerUI.setPlayer(player);
        }
    }
}
