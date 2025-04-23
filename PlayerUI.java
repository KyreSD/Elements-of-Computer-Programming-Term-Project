import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A minimalist UI class that displays player stats including health, potions, XP, and ability cooldowns.
 */
public class PlayerUI extends Actor
{
    private PlayerOne player;
    private GreenfootImage potionIcon;
    private GreenfootImage fireBallIcon;
    private GreenfootImage currentImage;
    
    // UI positioning constants
    private static final int UI_WIDTH = 200;
    private static final int UI_HEIGHT = 100;  // Increased height to accommodate icons below text
    private static final int ICON_SIZE = 32;  // Increased icon size to 32
    private static final int PADDING = 8;
    
    // Colors for UI elements
    private static final Color XP_COLOR = new Color(66, 133, 244);
    private static final Color BG_COLOR = new Color(0, 0, 0, 150);
    private static final Color OUTLINE_COLOR = new Color(255, 255, 255, 100);
    private static final Color TEXT_COLOR = new Color(255, 255, 255, 230);
    
    // Health bar reference
    private PlayerHealthBar healthBar = null;
    
    /**
     * Create a new UI for the specified player.
     */
    public PlayerUI(PlayerOne player) {
        this.player = player;
        
        // Initialize images
        potionIcon = new GreenfootImage("Potion.png");
        potionIcon.scale(ICON_SIZE, ICON_SIZE);
        
        fireBallIcon = new GreenfootImage("fireball.png");
        fireBallIcon.scale(ICON_SIZE, ICON_SIZE);
        
        // Create the base image
        currentImage = new GreenfootImage(UI_WIDTH, UI_HEIGHT);
        
        // Set initial image
        updateUI();
    }
    
    /**
     * When added to world, position the UI and find the health bar if it exists
     */
    public void addedToWorld(World world) {
        setLocation(UI_WIDTH / 2 + PADDING, UI_HEIGHT / 2 + PADDING);
        
        // Look for existing health bar in the world
        java.util.List<PlayerHealthBar> existingBars = world.getObjects(PlayerHealthBar.class);
        if (!existingBars.isEmpty()) {
            healthBar = existingBars.get(0);
        } else {
            // Only create a new health bar if one doesn't exist
            healthBar = new PlayerHealthBar(player);
            world.addObject(healthBar, getX(), getY() - 25);  // Adjusted position to account for taller UI
        }
    }
    
    /**
     * Act - update the UI elements
     */
    public void act() {
        updateUI();
    }
    
    /**
     * Update all UI elements based on player's current state
     */
    private void updateUI() {
        if (player == null) return;
        
        // Clear the image
        currentImage.clear();
        
        // Draw background
        currentImage.setColor(BG_COLOR);
        currentImage.fillRect(0, 0, UI_WIDTH, UI_HEIGHT);
        currentImage.setColor(OUTLINE_COLOR);
        currentImage.drawRect(0, 0, UI_WIDTH - 1, UI_HEIGHT - 1);
        
        // Draw XP bar
        int xpNeeded = 100;
        int xpPercentage = player.getxp() * 100 / xpNeeded;
        drawBar(currentImage, PADDING, PADDING + 10, UI_WIDTH - PADDING * 2, 4, xpPercentage, XP_COLOR);
        
        // Draw level indicator
        currentImage.setColor(TEXT_COLOR);
        currentImage.setFont(new Font("SansSerif", false, false, 12));
        currentImage.drawString("LVL " + player.getLevel(), PADDING, PADDING + 30);
        
        // Add health display showing actual values and percentage
        int healthPercentage = (player.getHealth() * 100) / player.getMaxHealth();
        currentImage.drawString("HP: " + player.getHealth() + "/" + player.getMaxHealth() + 
                               " (" + healthPercentage + "%)", PADDING + 60, PADDING + 30);
        
        // Position icons below the HP text
        // Calculate positions for first row of icons (below the HP text)
        int iconY = PADDING + 40;  // Y position below the HP text
        
        // Position potion icon on the left side
        currentImage.drawImage(potionIcon, PADDING, iconY);
        currentImage.setColor(TEXT_COLOR);
        currentImage.setFont(new Font("SansSerif", false, false, 14));  // Slightly larger font for numbers
        currentImage.drawString("" + player.getPotionCount(), PADDING + ICON_SIZE + 5, iconY + ICON_SIZE - 8);
        
        // Position fireball icon on the right side if available
        if (player.getCanAttackFireball()) {
            currentImage.drawImage(fireBallIcon, UI_WIDTH - PADDING - ICON_SIZE, iconY);
        }
        
        // Set the updated UI image
        setImage(currentImage);
    }
    
    /**
     * Draw a generic progress bar
     */
    private void drawBar(GreenfootImage img, int x, int y, int width, int height, int percentage, Color fillColor) {
        // Draw background
        img.setColor(new Color(40, 40, 40, 200));
        img.fillRect(x, y, width, height);
        
        // Draw fill based on percentage
        img.setColor(fillColor);
        int fillWidth = width * Math.min(percentage, 100) / 100;
        if (fillWidth > 0) {
            img.fillRect(x, y, fillWidth, height);
        }
    }
    
    /**
     * Update the player reference if needed.
     */
    public void setPlayer(PlayerOne player) {
        this.player = player;
        if (healthBar != null) {
            healthBar.setPlayer(player);
        }
    }
}