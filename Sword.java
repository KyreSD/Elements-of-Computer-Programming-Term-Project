import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Weapon
{
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    private GreenfootImage[] scaledFrames;
    private int frameWidth, frameHeight;
    private int animationFrame;
    private int frameDelay; // Adjust this for animation speed
    private int delayCounter;
    int damage;
    int damageCheck;
    private boolean isAnimating;
    private int cols;
    private int rows;
    private PlayerOne player;  // Reference to the player
    private int offsetX, offsetY;  // Offset from player position
    public Sword(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        damage = 20;
        level = 0;
        animationFrame = 0;
        frameDelay = 2; // Slightly increased for smoother animation
        delayCounter = 0;
        damageCheck = 0;
        isAnimating = true;  // Start animating immediately when created
        
        // Load and process sprite sheet
        loadSpriteSheet();
        
        // Find player reference (will be set in the first act call)
        player = null;
    
    }
    
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (player == null && getWorld() != null) {
            // Try to find player if not already set
            java.util.List<PlayerOne> players = getWorld().getObjects(PlayerOne.class);
            if (!players.isEmpty()) {
                player = players.get(0);
            }
        }
        swingSword();
        
        if (player != null) {
            updatePosition();
        }
    }
    
    /**
     * Update the sword's position based on the player's position and direction
     */
    private void updatePosition() {
        // Calculate position based on player's direction
        if (player.isFacingNorth) {
            setLocation(player.getX(), player.getY() - 60);
            setRotation(270);
        } else if (player.isFacingSouth) {
            setLocation(player.getX(), player.getY() + 60);
            setRotation(90);
        } else if (player.isFacingWest) {
            setLocation(player.getX() - 60, player.getY());
            setRotation(180);
        } else if (player.isFacingEast) {
            setLocation(player.getX() + 60, player.getY());
            setRotation(0);
        }
    }
    
    private void loadSpriteSheet() {
        spriteSheet = new GreenfootImage("spriteSheetSword.png");
        frameWidth = spriteSheet.getWidth() / cols;
        frameHeight = spriteSheet.getHeight() / rows;
        
        frames = new GreenfootImage[cols * rows];
        scaledFrames = new GreenfootImage[cols * rows];
        
        // Extract and pre-scale frames
        int index = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                frames[index] = new GreenfootImage(frameWidth, frameHeight);
                frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                
                // Create pre-scaled versions (100x100)
                scaledFrames[index] = new GreenfootImage(frames[index]);
                scaledFrames[index].scale(100, 100);
                
                index++;
            }
        }
        // Set initial frame
        setImage(scaledFrames[0]);
    }
    
    public void addedToWorld(World world) {
        // Find the player when added to the world
        player = (PlayerOne) getWorld().getObjects(PlayerOne.class).get(0);
        
        // Initialize position relative to player
        updatePosition();
    }
    
    public void swingSword() {
        if (!isAnimating && Greenfoot.isKeyDown("right")) {
            isAnimating = true;
            animationFrame = 0;
            delayCounter = frameDelay;
        }
        
        if (isAnimating) {
            if (delayCounter == 0) {
                // Use pre-scaled frames to avoid scaling issues
                setImage(scaledFrames[animationFrame]);
                animationFrame++;
                
                if (animationFrame >= scaledFrames.length) {
                    isAnimating = false;
                    animationFrame = 0;
                }
                
                delayCounter = frameDelay;
            } else {
                delayCounter--;
            }
        }
    }
    public void setDamage(int level) {
        damage = 20 + (level * 5);
    }
}
