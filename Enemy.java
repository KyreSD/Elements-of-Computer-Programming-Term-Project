import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    int frameWidth, frameHeight;
    private int currentFrame = 0;
    private int frameDelay = 5; // Adjust for speed
    private int delayCount = 0;
    //frameStarts
    int frameNorth = 18;
    int frameSouth = 0;
    int frameEast = 12;
    int frameWest = 6;
    private HealthSets hese = new HealthSets();
    int health = hese.healthEnemy;
    int cols = 6;
    int rows = 4;
    int X;
    int Y;
    private Placeholder placeholder;
    private EnemyTracking enemyTrack = null;
    public Enemy() {
        spriteSheet = new GreenfootImage("zombie_n_skeleton2.png");
        frameWidth = spriteSheet.getWidth() / cols;
        frameHeight = spriteSheet.getHeight() / rows;
        frames = new GreenfootImage[cols * rows];
        int index = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                frames[index] = new GreenfootImage(frameWidth, frameHeight);
                frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                index++;
            }
        }
        setImage(frames[0]);
    }
    public void setTracker(EnemyTracking tracker){
        enemyTrack = tracker;
    }
    public void act(){
        //sSystem.out.println("Enemy health: " + health);
        X = getX();
        Y = getY();
        if (enemyTrack != null) {
            setLocation(enemyTrack.getX(), enemyTrack.getY());
            enemyTrack.health = health;
        } 
        Sword sword = (Sword)getOneIntersectingObject(Sword.class);
        if (sword != null){
            health = health-3;
        }
        Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        if (placeholder != null){
            if (placeholder.playerHealth > 0){
                placeholder.playerHealth -= 1;
            } else {
                getWorld().removeObject(placeholder);
                placeholder = null;
            }
        }
        trackPlayer();
        checkHealth();
        //animate();
    }
    public void trackPlayer(){
        if (!getWorld().getObjects(Placeholder.class).isEmpty()){
            for (Placeholder placeholder : getWorld().getObjects(Placeholder.class)){
                if (placeholder.getX() < getX()){
                    if (Math.abs(placeholder.getX() - getX()) > Math.abs(getY() - placeholder.getY())){
                        animateWalkWest();
                    } else {
                        if (placeholder.getY() <= getY()){
                            animateWalkNorth();
                        } else {
                            animateWalkSouth();
                        }
                    }
                }
                if (placeholder.getX() >= getX()){
                    if (Math.abs(placeholder.getX() - getX()) > Math.abs(getY() - placeholder.getY())){
                        animateWalkEast();
                    } else {
                        if (placeholder.getY() <= getY()){
                            animateWalkNorth();
                        } else {
                            animateWalkSouth();
                        }
                    }
                }
            }
        }
    }
    /*private void animate() {
        delayCount++;
        int cols = 6;
        int rows = 4;
        int index = 0;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                frames[index] = new GreenfootImage(frameWidth, frameHeight);
                frames[index].drawImage(spriteSheet, -x * frameWidth, -y * frameHeight);
                index++;
            }
        }
        if (delayCount >= frameDelay) {
            delayCount = 0;
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
            frames[currentFrame].rotate(getRotation()-getRotation()*2);
        }
    }*/
    public void checkHealth(){
        if (health <= 0){
            dropXp();
            getWorld().removeObject(this);
            System.out.println("XP has dropped");
        }
    }
    public void dropXp(){
        MyWorld world = (MyWorld)getWorld();
        if (world != null){
            world.addObject(new XpDropped(), X,Y);
        }
    }
    //Animation
    private void animateWalkNorth() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameNorth = (frameNorth + 1) % frames.length;
            if (frameNorth < 18 || frameNorth == 21){
                frameNorth = 18;
            }
        }
        setImage(frames[frameNorth]);
    }
    private void animateWalkSouth() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameSouth = (frameSouth + 1) % frames.length;
            if (frameSouth < 0 || frameSouth == 3){
                frameSouth = 0;
            }
        }
        setImage(frames[frameSouth]);
    }
    private void animateWalkEast() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameEast = (frameEast + 1) % frames.length;
            if (frameEast < 12 || frameEast == 15){
                frameEast = 12;
            }
        }
        setImage(frames[frameEast]);
    }
    private void animateWalkWest() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameWest = (frameWest + 1) % frames.length;
            if (frameWest < 6 || frameWest == 9){
                frameWest = 6;
            }
        }
        setImage(frames[frameWest]);
    }
}