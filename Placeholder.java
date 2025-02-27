import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Placeholder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Placeholder extends Actor
{
    /**
     * Act - do whatever the Placeholder wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Sprite Sheet Shenanigans
    private GreenfootImage spriteSheet;
    private GreenfootImage[] frames;
    private int frameWidth, frameHeight;
    private int currentFrame = 0;
    private int frameDelay = 5; // Adjust for speed
    private int delayCount = 0;
    //frameStarts
    int northFrame = 16;
    int southFrame = 12;
    int eastFrame = 4;
    int westFrame = 8;
    int rotateInt = 90;
    boolean isFacingNorth, isFacingSouth, isFacingEast, isFacingWest = false;
    public Placeholder(String sheetPath, int cols, int rows) {
        spriteSheet = new GreenfootImage(sheetPath);
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
        int rotCount = 0;
        while (rotCount == 0){
            frames[12].rotate(90);
            frames[13].rotate(90);
            frames[14].rotate(90);
            frames[15].rotate(90);
            frames[16].rotate(90);
            frames[17].rotate(90);
            frames[18].rotate(90);
            frames[19].rotate(90);
            rotCount += 1;
        }

        setImage(frames[0]); // Set initial frame
    }
    
    
    int playerHealth = 1000000;
    int speed = 3;
    //Privates
    private Sword sword;
    private Fireball fireball;
    //Timers
    int timerSword = 50;
    int timerFireball = 300;
    //Attack Timers
    int attackTimerSword = 0;
    int attackTimerFireball = 0;
    //Can Attacks
    boolean canAttackSword = true;
    boolean canAttackFireball = true;
    //Click booleans
    boolean clickSword = true;
    boolean clickFireball = true;
    //Spawns
    private void spawnSword(int x, int y) {
        if (sword == null) {
            sword = new Sword("spriteSheetSword.png",6,1);
            getWorld().addObject(sword, x, y);
            attackTimerSword = timerSword;
        }
    }
    private void spawnFireball(int x, int y) {
        if (fireball == null) {
            fireball = new Fireball();
            getWorld().addObject(fireball, x, y);
            attackTimerFireball = timerFireball;
        }
    }
    public void act()
    {
        
        if (Greenfoot.isKeyDown("a")){
            animateWalkWest();
            setRotation(0);
            move(-speed);
        }
        if (Greenfoot.isKeyDown("d")){
            animateWalkEast();
            setRotation(0);
            move(speed);
        }
        if (Greenfoot.isKeyDown("w")){
            animateWalkNorth();
            setRotation(270);
            move(speed);
        }
        if (Greenfoot.isKeyDown("s")){
            animateWalkSouth();
            setRotation(270);
            move(-speed);
        } 
        if (Greenfoot.isKeyDown("shift")){
            if (speed == 3){
                speed += 3;
                frameDelay -= 2;
                System.out.println(speed);
            }
        } else {
            if (speed > 3){
                speed -= 3;
                frameDelay += 2;
            }
        }
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (enemy != null){
            playerHealth -= 1;
        }
        if (playerHealth == 0){
            move(-20);
        }
        attacking();
    }
    public int playerLocationX(){
        return getX();
    }
    public int playerLocationY(){
        return getY();
    }
    public void attacking(){
        
        if (Greenfoot.isKeyDown("right") && canAttackSword) {
            clickSword = true;
            if (Greenfoot.isKeyDown("w")) {
                spawnSword(getX(), getY() - 60);
            } else if (Greenfoot.isKeyDown("a")) {
                spawnSword(getX() - 60, getY());
            } else if (Greenfoot.isKeyDown("s")) {
                spawnSword(getX(), getY() + 60);
            } else {
                spawnSword(getX() + 60, getY());
            }
        }
        if (Greenfoot.isKeyDown("up") && canAttackFireball) {
            clickFireball = true;
            spawnFireball(getX(), getY());
        }

        if (clickSword == true){
            if (attackTimerSword > 0) {
                attackTimerSword--;
                if (attackTimerSword == timerSword - 20 && sword != null) {
                    getWorld().removeObject(sword);
                    sword = null;
                }
                if (attackTimerSword == 0) {
                    canAttackSword = true;
                    attackTimerSword = timerSword;
                    clickSword = false;
                } else {
                    canAttackSword = false;
                }
            }
        }
        if (clickFireball == true){
            if (attackTimerFireball > 0) {
                attackTimerFireball--;
                if (attackTimerFireball == timerFireball - 240 && fireball != null) {
                    getWorld().removeObject(fireball);
                    fireball = null;
                }
                if (attackTimerFireball == 0) {
                    canAttackFireball = true;
                    attackTimerFireball = timerFireball;
                    clickFireball = false;
                } else {
                    canAttackFireball = false;
                }
            }
        }
    }
    
    //Animate voids
    private void animateIdleNorth() {
        setImage(frames[3]);
    }
    private void animateIdleSouth() {
        setImage(frames[0]);
    }
    private void animateIdleEast() {
        setImage(frames[1]);
    }
    private void animateIdleWest() {
        setImage(frames[2]);
    }
    private void animate() {
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }
    private void animateWalkNorth() {
        setImage(frames[northFrame]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            northFrame = (northFrame + 1) % frames.length;
            System.out.println(northFrame);
            if (northFrame < 16){
                northFrame = 16;
            }
        }
    }
    private void animateWalkSouth() {
        setImage(frames[southFrame]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            southFrame = (southFrame + 1) % frames.length;
            System.out.println(southFrame);
            if (southFrame < 12 || southFrame == 16){
                southFrame = 12;
            }
        }
    }
    private void animateWalkEast() {
        setImage(frames[eastFrame]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            eastFrame = (eastFrame + 1) % frames.length;
            System.out.println(eastFrame);
            if (eastFrame < 4 || eastFrame == 8){
                eastFrame = 4;
            }
        }
    }
    private void animateWalkWest() {
        setImage(frames[westFrame]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            westFrame = (westFrame + 1) % frames.length;
            System.out.println(westFrame);
            if (westFrame < 8 || westFrame == 12){
                westFrame = 8;
            }
        }
    }
}   
