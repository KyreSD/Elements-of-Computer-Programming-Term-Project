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
    // Music variables - make them static so they persist across world changes
    private static GreenfootSound grassMusic;
    private static GreenfootSound dungeonMusic;
    private static GreenfootSound bossOneMusic;
    private static GreenfootSound bossTwoMusic;
    private static GreenfootSound currentMusic;
    private static WORLDSTATE currentWorldType;
    private static boolean musicInitialized = false;
    
    // Sound effects
    private static GreenfootSound swordSwingSound;
    private static GreenfootSound swordYellSound;
    private static GreenfootSound playerDamageSound;
    private static GreenfootSound enemyDamageSound;
    
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
        
        // Initialize music only once
        if (!musicInitialized) {
            initializeMusic();
        }
        
        // Start playing appropriate music based on world type
        updateBackgroundMusic(player.WorldType);
    }
    
    public SuperWorld(PlayerOne player, int x, int y, int z) {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(x, y, 1);
        this.player = player;
        
        // Add the existing player to the world at the specified position
        addObject(player, x, y);
        
        // Setup UI elements
        prepareUI();
        updateUIReferences();
        // Initialize music only once
        if (!musicInitialized) {
            initializeMusic();
        }
        
        // Start playing appropriate music
        updateBackgroundMusic(player.WorldType);
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
    
    // Separate method to initialize music
    private void initializeMusic() {
        // Initialize music tracks
        grassMusic = new GreenfootSound("Grass.mp3");
        dungeonMusic = new GreenfootSound("Dungeon.mp3");
        bossOneMusic = new GreenfootSound("Breakout.mp3");
        bossTwoMusic = new GreenfootSound("BossRoom.mp3");
        
        // Initialize sound effects
        swordSwingSound = new GreenfootSound("SwordSlash.mp3");
        swordYellSound = new GreenfootSound("SwordYell.mp3");

        playerDamageSound = new GreenfootSound("TakeDamage.mp3");
        enemyDamageSound = new GreenfootSound("TakeDamage.mp3");
        
        // Default world type
        currentWorldType = WORLDSTATE.GRASS;
        currentMusic = grassMusic;
        
        // Set music volume
        grassMusic.setVolume(50);
        dungeonMusic.setVolume(50);
        bossOneMusic.setVolume(50);
        bossTwoMusic.setVolume(50);
        
        // Set sound effect volumes
        swordSwingSound.setVolume(85);
        swordYellSound.setVolume(85);
        playerDamageSound.setVolume(85);
        enemyDamageSound.setVolume(85);
        
        musicInitialized = true;
    }
    
    // Call this to start music if it's not already playing
    public void ensureMusicPlaying() {
        if (currentMusic != null && !currentMusic.isPlaying()) {
            currentMusic.playLoop();
        }
    }
    
    // Method to update music when world type changes
    public void updateBackgroundMusic(WORLDSTATE newWorldType) {
        // Only change music if the world type is different
        if (newWorldType != currentWorldType || currentMusic == null || !currentMusic.isPlaying()) {
            currentWorldType = newWorldType;
            
            // Stop current music
            if (currentMusic != null && currentMusic.isPlaying()) {
                currentMusic.stop();
            }
            
            // Set new music based on world type
            switch (currentWorldType) {
                case GRASS:
                    currentMusic = grassMusic;
                    break;
                case DUNGEON:
                    currentMusic = dungeonMusic;
                    break;
                case BOSSONE:
                    currentMusic = bossOneMusic;
                    break;
                case BOSSTWO:
                    currentMusic = bossTwoMusic;
                    break;
            }
            
            // Start the new music (only if not already playing)
            if (currentMusic != null && !currentMusic.isPlaying()) {
                currentMusic.playLoop();
            }
        }
    }
    
    // Sound effect methods with null checks
    public static void playSwordSwingSound() {
        if (swordSwingSound != null) {
            swordSwingSound.play();
        }
    }
    
    public static void playSwordYellSound() {
        if (swordYellSound != null) {
            swordYellSound.play();
        }
    }
    
    public static void playPlayerDamageSound() {
        if (playerDamageSound != null) {
            playerDamageSound.play();
        }
    }
    
    public static void playEnemyDamageSound() {
        if (enemyDamageSound != null) {
            enemyDamageSound.play();
        }
    }
    
    
}
