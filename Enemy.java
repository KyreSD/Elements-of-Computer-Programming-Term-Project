import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemy class that handles both movement and tracking functionality.
 * The EnemyTracking class has been integrated into this class.
 * Updated to work directly with PlayerOne, Sword, and FireBall.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Entity
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int health;
    //default damage for enemies
    protected int damage = 10;
    //Miniboss
    protected boolean miniBoss = false;
    
    private int maxHealth;
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    private GreenfootImage[] scaledFrames;
    int frameWidth, frameHeight;
    private int currentFrame;
    private int frameDelay; // Adjust for speed
    private int delayCount;
    
    // Direction flags
    private boolean isFacingSouth;
    private boolean isFacingWest;
    private boolean isFacingEast;
    private boolean isFacingNorth;
    
    private int cols;
    private int rows;
    private int frame;
    private int X;
    private int Y;
    
    // Combat properties
    public int damageDelay; // Prevents taking damage too rapidly
    private static final int DAMAGE_COOLDOWN = 10; // Frames between damage
    private EnemyHealthBar healthBar = null;
    
    // Knockback properties
    private boolean isKnockedBack;
    private int knockbackDuration;
    private static final int MAX_KNOCKBACK_DURATION = 10;
    private int knockbackX;
    private int knockbackY;
    private static final int KNOCKBACK_STRENGTH = 10; // How far enemy gets pushed
    
    public Enemy() {
        // Initialize health and combat properties
        health = 100;
        maxHealth = 100;
        damageDelay = 0;
        
        // Initialize animation properties
        currentFrame = 0;
        frameDelay = 5; // Adjust for speed
        delayCount = 0;
        frame = 0;
        
        // Initialize direction flags
        isFacingSouth = true;
        isFacingWest = false;
        isFacingEast = false;
        isFacingNorth = false;
        
        // Initialize knockback properties
        isKnockedBack = false;
        knockbackDuration = 0;
        knockbackX = 0;
        knockbackY = 0;
        
        // Initialize position tracking
        X = 0;
        Y = 0;
        
        // Set sprite sheet configuration
        cols = 6; // Each direction has 3 animation frames
        rows = 4; // 4 directions (South, West, East, North)
        
        // Load and prepare sprite sheet
        spriteSheet = new GreenfootImage("zombie_n_skeleton2.png");
        frameWidth = spriteSheet.getWidth() / cols;
        frameHeight = spriteSheet.getHeight() / rows;
        
        loadSpriteSheet();
    }
    
    public void addedToWorld(World world) {
        // Create and attach health bar
        if (world != null) {
            healthBar = new EnemyHealthBar();
            world.addObject(healthBar, getX(), getY() - frameHeight/3);
            healthBar.setTracker(this);
        }
    }
    
    public void act(){
        this.X = getX();
        this.Y = getY();
        
        if (isKnockedBack) {
            applyKnockback();
        } else {
            trackPlayer(); // Move enemy toward player
        }
        
        checkCombat(); // Handle combat interactions
        
        if (damageDelay > 0) {
            damageDelay--;
        }
        
        checkHealth();
    }
    
    // Updated to use directional flags and improved animation
    public void trackPlayer(){
        if (!getWorld().getObjects(PlayerOne.class).isEmpty()){
            PlayerOne player = (PlayerOne)getWorld().getObjects(PlayerOne.class).get(0);
            
            // Calculate direction to player
            int dx = player.getPlayerX() - getX();
            int dy = player.getPlayerY() - getY();
            
            // Set animation direction based on which axis has the larger difference
            if (Math.abs(dx) > Math.abs(dy)) {
                // Moving horizontally
                if (dx < 0) {
                    // Moving west
                    isFacingWest = true;
                    isFacingEast = isFacingNorth = isFacingSouth = false;
                } else {
                    // Moving east
                    isFacingEast = true;
                    isFacingWest = isFacingNorth = isFacingSouth = false;
                }
            } else {
                // Moving vertically
                if (dy < 0) {
                    // Moving north
                    isFacingNorth = true;
                    isFacingWest = isFacingEast = isFacingSouth = false;
                } else {
                    // Moving south
                    isFacingSouth = true;
                    isFacingWest = isFacingEast = isFacingNorth = false;
                }
            }
            
            // Update animation based on current direction
            updateAnimation();
            
            // Move toward player (without rotating the sprite)
            int moveX = 0;
            int moveY = 0;
            
            if (dx != 0) {
                moveX = (dx > 0) ? 1 : -1;
            }
            
            if (dy != 0) {
                moveY = (dy > 0) ? 1 : -1;
            }
            
            // Move at the desired speed
            setLocation(getX() + moveX * 2, getY() + moveY * 2);
        }
    }
    
    /**
     * Handle combat interactions with the player, sword, and fireball
     */
    public void checkCombat() {
        if (damageDelay <= 0) {
            // Check for sword damage
            Sword sword = (Sword)getOneIntersectingObject(Sword.class);
            if (sword != null) {
                takeDamage(sword.damage);
                applyKnockbackFrom(sword.getX(), sword.getY());
                damageDelay = DAMAGE_COOLDOWN;
            }
            
            // Check for fireball damage
            FireBall fireBall = (FireBall)getOneIntersectingObject(FireBall.class);
            if (fireBall != null) {
                takeDamage(fireBall.damage);
                applyKnockbackFrom(fireBall.getX(), fireBall.getY());
                damageDelay = DAMAGE_COOLDOWN;
            }
            
            // Check for player collision and apply damage to player
            PlayerOne player = (PlayerOne)getOneIntersectingObject(PlayerOne.class);
            if (player != null) {
                // Let SuperWorld handle the damage to player via act method
                // This will be processed in SuperWorld.checkCombat()
            }
        }
    }
    
    /**
     * Apply knockback effect from a damage source
     */
    private void applyKnockbackFrom(int sourceX, int sourceY) {
        // Calculate knockback direction (away from damage source)
        int dx = getX() - sourceX;
        int dy = getY() - sourceY;
        
        // Normalize the vector
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (distance > 0) {
            knockbackX = (int)(dx / distance * KNOCKBACK_STRENGTH);
            knockbackY = (int)(dy / distance * KNOCKBACK_STRENGTH);
        } else {
            // If distance is zero (very rare case), default to a slight backward push
            knockbackX = KNOCKBACK_STRENGTH;
            knockbackY = 0;
        }
        
        isKnockedBack = true;
        knockbackDuration = MAX_KNOCKBACK_DURATION;
    }
    
    /**
     * Apply the knockback movement
     */
    private void applyKnockback() {
        if (knockbackDuration > 0) {
            setLocation(getX() + knockbackX, getY() + knockbackY);
            knockbackDuration--;
            
            // Reduce knockback effect gradually
            knockbackX = (int)(knockbackX * 0.8);
            knockbackY = (int)(knockbackY * 0.8);
        } else {
            isKnockedBack = false;
        }
    }
    
    /**
     * Take damage and update health
     */
    public void takeDamage(int damage) {
        health -= damage;
        // Health bar will update in its act method
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int enemyHealth(){
        return health;
    }
    
    public void checkHealth(){
        if (health <= 0){
            dropXp();
            if (healthBar != null) {
                getWorld().removeObject(healthBar);
            }
            getWorld().removeObject(this);
        }
    }
    
    // In Enemy.java, modify the dropXp method:
    public void dropXp(){
        SuperWorld world = (SuperWorld)getWorld();
        if (world != null){
            // 50/50 chance to drop XP or potion
            if (Greenfoot.getRandomNumber(2) == 0) {
                // Drop XP
                getWorld().addObject(new XpDropped(), X, Y);
            } else {
                // Drop potion
                getWorld().addObject(new PotionDropped(), X, Y);
            }
        }
    }
    
    public void dropKey() {
        SuperWorld world = (SuperWorld)getWorld();
        if (world != null) {
            getWorld().addObject(new Key(), getX(), getY()-30);
        }
    }
    
    // Load sprite sheet for animation
    private void loadSpriteSheet() {
        frames = new GreenfootImage[cols * rows];
        scaledFrames = new GreenfootImage[cols * rows];
        
        int index = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                frames[index] = new GreenfootImage(frameWidth, frameHeight);
                frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                
                // Create scaled frames for better appearance
                scaledFrames[index] = new GreenfootImage(frames[index]);
                scaledFrames[index].scale(350, 350);
                
                index++;
            }
        }
        
        // Set initial frame to south-facing
        frame = 0;
        setImage(frames[frame]);
    }
    
    // Update animation frames based on direction
    private void updateAnimation() {
        int rowIndex = 0; // Default to south-facing
        
        if (isFacingSouth) {
            rowIndex = 0; // Row 1 for south
        } else if (isFacingWest) {
            rowIndex = 1; // Row 2 for west
        } else if (isFacingEast) {
            rowIndex = 2; // Row 3 for east
        } else if (isFacingNorth) {
            rowIndex = 3; // Row 4 for north
        }
        
        // Calculate frame indices for this row
        int startIndex = rowIndex * cols;
        int endIndex = startIndex + cols - 1;
        
        // Update animation frame with proper delay
        delayCount++;
        if (delayCount >= frameDelay) {
            frame = startIndex + ((frame - startIndex + 1) % cols);
            if (frame < startIndex || frame > endIndex) {
                frame = startIndex;
            }
            setImage(frames[frame]);
            delayCount = 0;
        }
    }
}
