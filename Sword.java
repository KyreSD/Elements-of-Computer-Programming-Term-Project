import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    private int frameWidth, frameHeight;
    private int animationFrame = 0;
    private int frameDelay = 2; // Adjust this for animation speed
    private int delayCounter = 0;
    int damage;
    int damageCheck = 0;
    private boolean isAnimating = false;
    public Sword(int cols, int rows) {
        spriteSheet = new GreenfootImage("spriteSheetSword.png");
        frameWidth = spriteSheet.getWidth() / cols;
        frameHeight = spriteSheet.getHeight() / rows;
        frames = new GreenfootImage[cols * rows];
        // Extract frames
        int index = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                frames[index] = new GreenfootImage(frameWidth, frameHeight);
                frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                index++;
            }
        }
    }
    public void act()
    {
        System.out.println("Sword damage is " + damage);
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        EnemyTracking enemyTrack = (EnemyTracking)getOneIntersectingObject(EnemyTracking.class);
        Punchingbag bag = (Punchingbag)getOneIntersectingObject(Punchingbag.class);
        if (enemy != null){    
            enemy.health = enemy.health - damage;
            if (enemyTrack != null){
                enemyTrack.move(-5);
                enemyTrack.health -= damage;
                if(enemyTrack.health <= 0){
                }
            }
            damageCheck += damage;
            if(enemy.health <= 0){
                getWorld().removeObject(enemy);
            }
        }
        if (bag != null){    
            damageCheck += damage;
            System.out.println(damageCheck);
        }
        handleAnimation();
    }
    /**private void handleAnimation() {
        if (Greenfoot.isKeyDown("right")) {
            if (Greenfoot.isKeyDown("w")){
                setRotation(270);
            } else if (Greenfoot.isKeyDown("a")){
                setRotation(180);
            } else if (Greenfoot.isKeyDown("s")){
                setRotation(90);
            } else if (Greenfoot.isKeyDown("d")){
                setRotation(0);
            } else setRotation(0);
            if (delayCounter == 0) {
                setImage(swingImages[animationFrame]); // Set image
                scaleImage(getImage(), 200, 200); // Scale it to 100x100 (adjust as needed)
                animationFrame++;
                if (animationFrame >= swingImages.length) {
                    animationuFrame = 0; // Reset animation
                }
                delayCounter = frameDelay;
            } else {
                delayCounter--; // Countdown
            }
        } else {
            animationFrame = 0; // Reset animation when not swinging
        }
    }**/
    public void updateDamage() {
        if (getWorld() != null) {
            damage = ((SuperWorld) getWorld()).damageSword;
        }
    }
    public void addedToWorld(World world) {
        updateDamage();
    }
    private void handleAnimation() {
        if (!isAnimating && Greenfoot.isKeyDown("right")) {
            isAnimating = true;
            animationFrame = 0;
            delayCounter = frameDelay;
        }
        if (isAnimating) {
            if (Greenfoot.isKeyDown("w")){
                setRotation(270);
            } else if (Greenfoot.isKeyDown("a")){
                setRotation(180);
            } else if (Greenfoot.isKeyDown("s")){
                setRotation(90);
            } else if (Greenfoot.isKeyDown("d")){
                setRotation(0);
            } else setRotation(0);
            if (delayCounter == 0) {
                frames[animationFrame].scale(100,100);
                setImage(frames[animationFrame]);
                animationFrame++;
                if (animationFrame >= frames.length) {
                    isAnimating = false;
                    animationFrame = 0;
                }
                delayCounter = frameDelay;
            } else {
                delayCounter--;
            }
        }
    }  
}
