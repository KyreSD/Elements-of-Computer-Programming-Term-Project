import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends Weapon
{
    int damage;
    int damageCheck = 0;
    boolean canTurn = true;
    private int speed = 4; // Increased speed for better gameplay
    private PlayerOne player;
    
    // Explosion animation variables
    private boolean exploding = false;
    private int explosionFrame = 0;
    private int explosionDelay = 3; // Controls animation speed
    private int explosionCounter = 0;
    private static final int TOTAL_EXPLOSION_FRAMES = 20;
    
    public FireBall() {
        damage = 30;
        level = 0;
        setImage("fireball.png");
        scaleImage(getImage(), 50, 50);
    }
    
    public void addedToWorld(World world) {
        // Find the player when added to the world
        player = (PlayerOne) getWorld().getObjects(PlayerOne.class).get(0);
        
        // Set initial direction based on player's facing
        if (player != null) {
            if (player.isFacingNorth) {
                setRotation(270);
            } else if (player.isFacingSouth) {
                setRotation(90);
            } else if (player.isFacingWest) {
                setRotation(180);
            } else { // Default East
                setRotation(0);
            }
        }
    }
    
    public int fireballLocationX() {
        return getX();
    }
    
    public int fireballLocationY() {
        return getY();
    }
 
    public void act() {
        if (exploding) {
            playExplosionAnimation();
        } else {
            move(speed);
            
            // Check if at edge of world
            if (isAtEdge()) {
                startExplosion();
                return;
            }
            
            // Check for enemy hits
            Actor enemy = getOneIntersectingObject(null); // Replace null with your enemy class
            if (enemy != null && !(enemy instanceof PlayerOne) && !(enemy instanceof Weapon)) {
                // Deal damage to enemy if you have an Enemy class
                // For example: ((Enemy)enemy).takeDamage(damage);
                
                startExplosion();
            }
        }
    }
    
    /**
     * Starts the explosion animation process
     */
    private void startExplosion() {
        exploding = true;
        explosionFrame = 0;
        explosionCounter = 0;
    }
    
    /**
     * Plays through the explosion animation frames
     */
    private void playExplosionAnimation() {
        explosionCounter++;
        
        if (explosionCounter >= explosionDelay) {
            explosionCounter = 0;
            
            // Set the explosion frame image
            setExplosionImage(explosionFrame);
            explosionFrame++;
            
            // Remove object after animation completes
            if (explosionFrame >= TOTAL_EXPLOSION_FRAMES) {
                getWorld().removeObject(this);
            }
        }
    }
    
    /**
     * Sets the appropriate explosion image based on the current frame
     */
    private void setExplosionImage(int frame) {
        String imageName = "SlashesFile" + (frame + 1) + ".png";
        setImage(imageName);
        
        // Scale image as needed for the explosion effect
        // You might want to make explosions larger than the fireball
        scaleImage(getImage(), 70, 70);
    }
    
    private void scaleImage(GreenfootImage img, int width, int height) {
        img.scale(width, height);
    }
}
