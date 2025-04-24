import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/*
 * Class Monster was created to work as a version of the Enemy Class 
 * that can handle the animation of gifs instead of sprite sheets
 */
public class Monster extends Enemy
{
    private boolean hasDroppedKey;
    //Combat Properties (Same as Enemy)
    public int health;
    protected int maxHealth;
    //private int damage = 10;
    private int damageDelay;
    private static final int DAMAGE_COOLDOWN = 10;
    private EnemyHealthBar healthBar = null;
    private boolean isKnockedBack;
    private int knockbackDuration;
    private static final int MAX_KNOCKBACK_DURATION = 10;
    private int knockbackX, knockbackY;
    private static final int KNOCKBACK_STRENGTH = 10;
    protected boolean keyNotDropped = true;
    
    //Initializing Gif Storage
    protected GifImage downAnimation;
    protected GifImage leftAnimation;
    protected GifImage rightAnimation;
    protected GifImage upAnimation;
    protected GifImage attackAnimation;
    
    //movement (same as Enemy)
    // Direction flags
    private boolean isFacingSouth;
    private boolean isFacingWest;
    private boolean isFacingEast;
    private boolean isFacingNorth;
    protected int speed = 2;
    
    public Monster() {
        //Refers to Enemy for health, damageDelay, etc...
        super();
        //Starting direction
        isFacingSouth = true;
        //default monster (not a miniboss)
        
    }
    
    public void addedToWorld(World world) {
        if (world != null) {
            healthBar = new EnemyHealthBar();
            world.addObject(healthBar, getX(), getY() - getImage().getHeight()/3);
            //healthBar.setTracker(this);
            ((EnemyHealthBar)healthBar).setTracker(this);
        }
    }
    
    public void act(){
        if (isKnockedBack) {
            applyKnockback();
        } else {
            trackPlayer(); // Move enemy toward player
        }
        checkCombat(); // Handle combat interactions
        updateGif();
        if (damageDelay > 0) {
            damageDelay--;
        }
        checkHealth();
    }
    
    
    protected void updateGif() {
        if (isFacingNorth) {
            setImage(upAnimation.getCurrentImage());
        } else if (isFacingSouth) {
            setImage(downAnimation.getCurrentImage());
        } else if (isFacingWest) {
            setImage(leftAnimation.getCurrentImage());
        } else if (isFacingEast) {
            setImage(rightAnimation.getCurrentImage());
        }
    }
    
    //@Override (permission issue)
    public void trackPlayer() {
        if (!getWorld().getObjects(PlayerOne.class).isEmpty()) {
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
            updateGif();
            
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
        //always drops key
        /*
        if (miniBoss && !hasDroppedKey) {
            getWorld().addObject(new Key(), getX(), getY());
            hasDroppedKey = true;
        }
        */
        
        SuperWorld world = (SuperWorld)getWorld();
        if (world != null){
            int X = getX();
            int Y = getY();
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
    
}
