import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Entity
{
    public int health;
    public int maxHealth;
    public int speed;
    public int level;
    public int xp;
    public int potionCount;
    public int potionHealth;
    private int select;
    private int swordCooldown;
    private boolean canSwordSwing;
    private boolean clickSword;
    private boolean clickFireball;
    public int fireBallCooldown;
    private Sword sword;
    private FireBall fireBall;
    //Timers
    int timerSword = 50;
    public int timerFireball = 300;
    //Attack Timers
    static int attackTimerSword = 0;
    public static int attackTimerFireball = 0;
    //Can Attacks
    boolean canAttackSword;
    public boolean canAttackFireball;
    //Click booleans
    int inactiveCount = 0;
    int invincibilityCount = 0;
    int invinEnd = 30;
    //Spawns
    public boolean isFacingNorth, isFacingSouth, isFacingEast, isFacingWest; // Made public for sword access
    
    //initialize Spritesheet Values
    private int cols;
    private int rows;
    private GreenfootImage[] walkRight, walkLeft, walkUp, walkDown;
    private int frame;
    private int frameDelay;
    private int delayCount;
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    private GreenfootImage[] scaledFrames;
    private int frameWidth, frameHeight;
    private int animationFrame;
    private int delayCounter;
    int damage;
    int damageCheck;
    private boolean isAnimating;
    
    // Knockback properties
    private boolean isKnockedBack = false;
    private int knockbackDuration = 0;
    private static final int MAX_KNOCKBACK_DURATION = 20;
    private int knockbackX = 0;
    private int knockbackY = 0;
    private static final int KNOCKBACK_STRENGTH = 15; // How far player gets pushed
    
    // Animation speed modifiers for each character type
    private int linkAnimationSpeed = 2;      // Adjust this value to change Link's animation speed
    private int boyAnimationSpeed = 2;       // Adjust this value to change Boy's animation speed
    private int retroAnimationSpeed = 2;     // Adjust this value to change Retro character's animation speed
    
    /**
     * Constructor to initialize Gameplay Values, location and sprite sheet.
     */
    public PlayerOne(){
        select = 1;
        health = 100;
        maxHealth = 300;
        speed = 3;
        level = 1;
        xp = 0;
        potionCount = 0;
        potionHealth = 75;
        swordCooldown = 0;
        fireBallCooldown = 0;
        canSwordSwing = true;
        canAttackFireball = true;
        clickSword = false;
        clickFireball = false;
        cols=10;
        rows=8;
        //Timers
        timerSword = 50;
        timerFireball = 300;
        //Attack Timers
        attackTimerSword = 0;
        attackTimerFireball = 0;
        //Can Attacks
        canAttackSword = true;
        canAttackFireball = true;
        //Click booleans
        inactiveCount = 0;
        invincibilityCount = 0;
        invinEnd = 30;
        //Spawns - Set default direction
        isFacingEast = true;
        isFacingNorth = false;
        isFacingSouth = false;
        isFacingWest = false;
        
        frameDelay = linkAnimationSpeed; // Initialize with Link's animation speed
        delayCount = 0;
        loadSpriteSheet();
    }
    
    public PlayerOne(int select, int cols, int rows){
        this.select = select;
        health = 100;
        maxHealth = 300;
        speed = 3;
        level = 1;
        xp = 0;
        potionCount = 0;
        potionHealth = 75;
        swordCooldown = 0;
        fireBallCooldown = 0;
        canSwordSwing = true;
        canAttackFireball = true;
        clickSword = false;
        clickFireball = false;
        this.cols=cols;
        this.rows=rows;
        //Timers
        timerSword = 50;
        timerFireball = 300;
        //Attack Timers
        attackTimerSword = 0;
        attackTimerFireball = 0;
        //Can Attacks
        canAttackSword = true;
        canAttackFireball = true;
        //Click booleans
        inactiveCount = 0;
        invincibilityCount = 0;
        invinEnd = 30;
        //Spawns - Set default direction
        isFacingEast = true;
        isFacingNorth = false;
        isFacingSouth = false;
        isFacingWest = false;
        
        // Set frameDelay based on character selection
        if (select == 0) {
            frameDelay = boyAnimationSpeed;
        } else if (select == 1) {
            frameDelay = linkAnimationSpeed;
        } else if (select == 2) {
            frameDelay = retroAnimationSpeed;
        }
        
        delayCount = 0;
        loadSpriteSheet();
    }
    
    /**
     * Act - do whatever the PlayerOne wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isKnockedBack) {
            applyKnockback();
        } else {
            checkMovement();
        }
        
        attacking();
        usePotion(); // Add this line to check for potion usage
        if (swordCooldown > 0) {
            swordCooldown--;
        }
        
        if (invincibilityCount > 0) {
            invincibilityCount--;
        }
        
        if (health <=0){
            Greenfoot.setWorld(new GameOver());
        }
        updateAnimation();
        checkCollisions(); // Add a new method to check for enemy collisions
    }
    
    //Return player location for functions inside of this Object.
    public int getPlayerX(){
        return getX();
    }
    
    public int getPlayerY(){
        return getY();  // Fixed this to actually return Y
    }
    
    public int getHealth(){
        return health;
    }
    
    public int getLevel(){
        return level;
    }
    
    public int getxp(){
        return xp;
    }
    
    public int getMaxHealth() {
        return maxHealth;
    }
    
    public int getPotionCount() {
        return potionCount;
    }
    
    public int getPotionHealth() {
        return potionHealth;
    }
    
    public boolean getCanAttackFireball() {
        return canAttackFireball;
    }
    
    public boolean getCanAttackSword() {
        return canAttackSword;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    /**
     * Check for collisions with enemies and take damage
     */
    private void checkCollisions() {
        if (invincibilityCount <= 0) {
            Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
            if (enemy != null) {
                // Take damage
                takeDamage(10);  // Assume enemy deals 10 damage per hit
                
                // Apply knockback from the enemy
                applyKnockbackFrom(enemy.getX(), enemy.getY());
                
                // Set invincibility period
                invincibilityCount = invinEnd;
            }
        }
    }
    
    /**
     * Take damage and update health
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        // In a full implementation, you might want to add game over check here
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
    
    // Modified checkMovement to set direction flags and handle animation
    public void checkMovement() {
        boolean isMoving = false;
        
        if (Greenfoot.isKeyDown("a")) {
            setRotation(180);
            move(speed);
            isFacingWest = true;
            isFacingEast = isFacingNorth = isFacingSouth = false;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("d")) {
            setRotation(0);
            move(speed);
            isFacingEast = true;
            isFacingWest = isFacingNorth = isFacingSouth = false;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("w")) {
            setRotation(270);
            move(speed);
            isFacingNorth = true;
            isFacingWest = isFacingEast = isFacingSouth = false;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("s")) {
            setRotation(90);
            move(speed);
            isFacingSouth = true;
            isFacingWest = isFacingEast = isFacingNorth = false;
            isMoving = true;
        } 
        if (Greenfoot.isKeyDown("shift")) {
            if (speed == 3) {
                speed += 3;
                // Reduce frameDelay for faster animation when running
                if (select == 0) {
                    frameDelay = boyAnimationSpeed - 2;
                } else if (select == 1) {
                    frameDelay = linkAnimationSpeed - 1;
                } else if (select == 2) {
                    frameDelay = retroAnimationSpeed - 1;
                }
            }
        } else {
            if (speed > 3) {
                speed -= 3;
                // Restore normal frameDelay
                if (select == 0) {
                    frameDelay = boyAnimationSpeed;
                } else if (select == 1) {
                    frameDelay = linkAnimationSpeed;
                } else if (select == 2) {
                    frameDelay = retroAnimationSpeed;
                }
            }
        }
    }
    
    //Animate Idle
    private void updateAnimation() {
        if (select == 1) { 
            // Link sprite animation - unchanged from previous version
            boolean isMoving = false;
            
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || 
                Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")) {
                isMoving = true;
            }
            
            int rowIndex;
            {
                if (isMoving) {
                    if (isFacingSouth) {
                        rowIndex = 4;
                    } else if (isFacingWest) {
                        rowIndex = 5;
                    } else if (isFacingNorth) {
                        rowIndex = 6;
                    } else {
                        rowIndex = 7;
                    }
                } else {
                    if (isFacingSouth) {
                        rowIndex = 0;
                    } else if (isFacingWest) {
                        rowIndex = 1;
                    } else if (isFacingNorth) {
                        rowIndex = 2;
                    } else {
                        rowIndex = 3;
                    }
                }
            }
            
            int startIndex = rowIndex * cols;
            int endIndex = startIndex + cols - 1;
            
            delayCount++;
            if (delayCount >= frameDelay) {
                if (isMoving) {
                    frame = startIndex + ((frame - startIndex + 1) % cols);
                    if (frame < startIndex || frame > endIndex) {
                        frame = startIndex;
                    }
                } else {
                    frame = startIndex;
                }
                setImage(scaledFrames[frame]);
                delayCount = 0;
            }
        } else if (select == 0) { 
            // Boy character animation (select == 0)
            boolean isMoving = false;
            
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || 
                Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")) {
                isMoving = true;
            }
            
            // Fixed animation frame selection
            if (!isMoving) {
                // Use the correct idle frame based on direction
                if (isFacingSouth) {
                    frame = 0; // South-facing idle
                } else if (isFacingEast) {
                    frame = 1; // East-facing idle
                } else if (isFacingWest) {
                    frame = 2; // West-facing idle
                } else { // North
                    frame = 3; // North-facing idle
                }
                setImage(scaledFrames[frame]);
            } else {
                // Walking animations
                int walkFrameDelay = frameDelay; // Use the character-specific frameDelay
                
                // Map direction to correct row in the spritesheet
                int rowIndex;
                if (isFacingSouth) {
                    rowIndex = 3; // Row 4 for walking south
                } else if (isFacingEast) {
                    rowIndex = 1; // Row 2 for walking east
                } else if (isFacingWest) {
                    rowIndex = 2; // Row 3 for walking west
                } else { // North
                    rowIndex = 4; // Row 5 for walking north
                }
                
                // Calculate frame within this row
                int startIndex = rowIndex * cols;
                int endIndex = startIndex + cols - 1;
                
                delayCount++;
                if (delayCount >= walkFrameDelay) {
                    frame = startIndex + ((frame - startIndex + 1) % cols);
                    if (frame < startIndex || frame > endIndex) {
                        frame = startIndex;
                    }
                    setImage(scaledFrames[frame]);
                    delayCount = 0;
                }
            }
        } else if (select == 2) { 
            // Retro character animation (select == 2)
            boolean isMoving = false;
            
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d") || 
                Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s")) {
                isMoving = true;
            }
            
            int rowIndex;
            if (isFacingSouth) {
                rowIndex = 0;
            } else if (isFacingNorth) {
                rowIndex = 1;
            } else if (isFacingWest) {
                rowIndex = 2;
            } else { // East
                rowIndex = 3;
            }
            
            int startIndex = rowIndex * cols;
            int endIndex = startIndex + cols - 1;
            
            if (!isMoving && isFacingEast) {
                frame = 15; // Last frame in the sheet for east-facing idle
            } else {
                delayCount++;
                if (delayCount >= frameDelay) {
                    if (isMoving) {
                        frame = startIndex + ((frame - startIndex + 1) % cols);
                        if (frame < startIndex || frame > endIndex) {
                            frame = startIndex;
                        }
                    } else {
                        frame = startIndex;
                    }
                    delayCount = 0;
                }
            }
            
            setImage(scaledFrames[frame]);
        }
    }
    
    /**
     * Set the character type and update sprite properties
     */
    public void setCharacterType(int select) {
        this.select = select;
        
        // Set appropriate dimensions based on character type
        if (select == 0) {
            setSpriteDimensions(4, 5);  // Boy
            frameDelay = boyAnimationSpeed;
        } else if (select == 1) {
            setSpriteDimensions(10, 8); // Link
            frameDelay = linkAnimationSpeed;
        } else if (select == 2) {
            setSpriteDimensions(4, 4);  // Retro
            frameDelay = retroAnimationSpeed;
        }
        
        // Reload sprite sheet with new dimensions
        loadSpriteSheet();
    }
    
    /**
     * Set the sprite sheet dimensions
     */
    public void setSpriteDimensions(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }
    
    private void loadSpriteSheet() {
        if(select == 1) {
            // Link sprite code - unchanged
            spriteSheet = new GreenfootImage("linkSprite.png");
            frame = 0;
            int verticalOffset = -5;
            
            frameWidth = spriteSheet.getWidth() / cols;
            frameHeight = spriteSheet.getHeight() / rows;
            
            frames = new GreenfootImage[cols * rows];
            scaledFrames = new GreenfootImage[cols * rows];
            
            int index = 0;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    frames[index] = new GreenfootImage(frameWidth, frameHeight);
                    frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight + verticalOffset);
                    
                    scaledFrames[index] = new GreenfootImage(frames[index]);
                    scaledFrames[index].scale(75, 75);
                    
                    index++;
                }
            }
            
            // Rotations for Link sprites (unchanged)
            for (int i = 10; i < 20; i++) { scaledFrames[i].rotate(180); }
            for (int i = 0; i < 10; i++) { scaledFrames[i].rotate(-90); }
            for (int i = 20; i < 30; i++) { scaledFrames[i].rotate(90); }
            for (int i = 50; i < 60; i++) { scaledFrames[i].rotate(180); }
            for (int i = 40; i < 50; i++) { scaledFrames[i].rotate(-90); }
            for (int i = 60; i < 70; i++) { scaledFrames[i].rotate(90); }
            
        } else if(select == 0) {
            // Boy character with FIXED rotations
            cols = 4;
            rows = 5;
            spriteSheet = new GreenfootImage("FullSheetBoy.png");
            
            frameWidth = spriteSheet.getWidth() / cols;
            frameHeight = spriteSheet.getHeight() / rows;
            
            frames = new GreenfootImage[cols * rows];
            scaledFrames = new GreenfootImage[cols * rows];
            
            int index = 0;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    frames[index] = new GreenfootImage(frameWidth, frameHeight);
                    frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                    
                    scaledFrames[index] = new GreenfootImage(frames[index]);
                    scaledFrames[index].scale(75, 75);
                    
                    index++;
                }
            }
            
            // FIXED ROTATIONS FOR BOY CHARACTER
            
            // Idle frames (0-3) rotations
            // Frame 0 - South-facing idle needs -90 degree rotation
            scaledFrames[0].rotate(-90);
            
            // Frame 1 - East-facing idle - no rotation needed
            
            // Frame 2 - West-facing idle needs 180 degree rotation (to flip from right to left)
            scaledFrames[2].rotate(180);
            
            // Frame 3 - North-facing idle needs 90 degree rotation
            scaledFrames[3].rotate(90);
            
            // Walking animations rotations (these were correct before)
            // Walking east (4-7) - no rotations needed
            
            // Walking west (8-11) needs to be rotated 180 degrees
            for (int i = 8; i < 12; i++) {
                scaledFrames[i].rotate(180);
            }
            
            // Walking south (12-15) needs to be rotated -90 degrees
            for (int i = 12; i < 16; i++) {
                scaledFrames[i].rotate(-90);
            }
            
            // Walking north (16-19) needs to be rotated 90 degrees
            for (int i = 16; i < 20; i++) {
                scaledFrames[i].rotate(90);
            }
            
        } else if(select == 2) {
            // Retro character with FIXED rotations
            cols = 4;
            rows = 4;
            spriteSheet = new GreenfootImage("RetroSpriteSheet.png");
            
            frameWidth = spriteSheet.getWidth() / cols;
            frameHeight = spriteSheet.getHeight() / rows;
            
            frames = new GreenfootImage[cols * rows];
            scaledFrames = new GreenfootImage[cols * rows];
            
            int index = 0;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    frames[index] = new GreenfootImage(frameWidth, frameHeight);
                    frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                    
                    scaledFrames[index] = new GreenfootImage(frames[index]);
                    scaledFrames[index].scale(75, 75);
                    
                    index++;
                }
            }
            
            // Walking south (row 1, indices 0-3) needs to be rotated -90 degrees
            for (int i = 0; i < 4; i++) {
                scaledFrames[i].rotate(-90);
            }
            
            // North-facing sprites (row 2, indices 4-7) 
            for (int i = 4; i < 8; i++) {
                scaledFrames[i].rotate(90);
            }
            
            // West-facing sprites (row 3, indices 8-11)
            for (int i = 8; i < 12; i++) {
                scaledFrames[i].rotate(180);
            }
            
            // No rotations for east-facing frames (row 4, indices 12-15)
        }
        
        // Set initial frame
        setImage(scaledFrames[0]);
    }
    
    public void attacking(){
        // Handle sword attack
        if(Greenfoot.isKeyDown("right")){
            if (canAttackSword) {
                clickSword = true;
                spawnSword();
                canAttackSword = false;
                attackTimerSword = timerSword;
            }
        }
        
        // Update sword attack timer
        if (attackTimerSword > 0) {
            attackTimerSword--;
            if (attackTimerSword == timerSword - 20 && sword != null) {
                getWorld().removeObject(sword);
                sword = null;
            }
            if (attackTimerSword == 0) {
                canAttackSword = true;
                clickSword = false;
            }
        }
        
        // Handle fireball attack
        if (Greenfoot.isKeyDown("up") && canAttackFireball) {
            clickFireball = true;
            spawnFireball(getX(), getY());
        }
        
        // Update fireball attack timer
        if (attackTimerFireball > 0) {
            attackTimerFireball--;
            if (attackTimerFireball == timerFireball - 240 && fireBall != null) {
                getWorld().removeObject(fireBall);
                fireBall = null;
            }
            if (attackTimerFireball == 0) {
                canAttackFireball = true;
                clickFireball = false;
            } else {
                canAttackFireball = false;
            }   
        }
    }   
    
    private void spawnSword() {
        // Calculate where to spawn the sword based on direction
        int swordX = getX();
        int swordY = getY();
        
        if (isFacingNorth) {
            swordY = getY() - 60;
        } else if (isFacingSouth) {
            swordY = getY() + 60;
        } else if (isFacingWest) {
            swordX = getX() - 60;
        } else { // Default to East
            swordX = getX() + 60;
        }
        
        // Create and place the sword
        if (sword == null) {
            sword = new Sword(6, 1);
            getWorld().addObject(sword, swordX, swordY);
        }
    }
    
    private void spawnFireball(int x, int y) {
        if (fireBall == null) {
            fireBall = new FireBall();
            getWorld().addObject(fireBall, x, y);
            attackTimerFireball = timerFireball;
        }
    }
    
    public void addXp(int value){
        xp+=value;
    }
    
    /**
     * Method to use potions when left arrow key is pressed
     */
    private void usePotion() {
        if (Greenfoot.isKeyDown("left") && potionCount > 0) {
            // Only use potion if health isn't already at max
            if (health < maxHealth) {
                // Add potion health to current health
                health += potionHealth;
                
                // Cap health at max health
                if (health > maxHealth) {
                    health = maxHealth;
                }
                
                // Decrease potion count
                potionCount--;
                
                // Add visual feedback or sound effect here if desired
                // For example: getWorld().addObject(new HealEffect(), getX(), getY());
            }
        }
    }
}

