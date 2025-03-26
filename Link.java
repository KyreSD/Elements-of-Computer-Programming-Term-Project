import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Link here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Link extends Actor
{
    /**
     * Act - do whatever the Link wants to do. This method is called whenever
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
    int frameNorth = 60;
    int frameSouth = 40;
    int frameEast = 70;
    int frameWest = 50;
    int rotateInt = 90;
    boolean isFacingNorth, isFacingSouth, isFacingEast, isFacingWest = false;
    
    World World2;
    
    public Link(String sheetPath, int cols, int rows) {
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
            for (int i = frameSouth; i < frameSouth + 10; i++){
                frames[i].rotate(90);
            }
            rotCount += 1;
        }

        setImage(frames[0]); // Set initial frame
    }
    
    HealthSets hese = new HealthSets();
    int playerHealth = hese.playerHealth;
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
    int inactiveCount = 0;
    int invincibilityCount = 0;
    int invinEnd = 30;
    //Spawns
    private void spawnSword(int x, int y) {
        if (sword == null) {
            sword = new Sword(6,1);
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
        System.out.println(playerHealth);
        if (Greenfoot.isKeyDown("a")){
            animateWalkWest();
            setRotation(180);
            move(speed);
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
            setRotation(90);
            move(speed);
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
        if (playerHealth == 0){
            move(-20);
        }
        attacking();
        if(playerLocationX()<2){
            World2 w = new World2(5, playerHealth, getWorld().getWidth()-getX(),getY());
            Greenfoot.setWorld(w);
        }
        if(playerLocationX()>598){
            MyWorld m = new MyWorld(5, playerHealth, getWorld().getWidth()-getX(),getY());
            Greenfoot.setWorld(m);
        }
    }
    public int playerLocationX(){
        return getX();
    }
    public int playerLocationY(){
        return getY();
    }
    public int attackCooldown(){
        return timerFireball;
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
                sword.setLocation(getX()+ 60,getY());
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
        setImage(frames[20]);
    }
    private void animateIdleSouth() {
        setImage(frames[0]);
    }
    private void animateIdleEast() {
        setImage(frames[30]);
    }
    private void animateIdleWest() {
        setImage(frames[10]);
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
        setImage(frames[frameNorth]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameNorth = (frameNorth + 1) % frames.length;
            if (frameNorth < 60){
                frameNorth = 60;
            }
        }
    }
    private void animateWalkSouth() {
        setImage(frames[frameSouth]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameSouth = (frameSouth + 1) % frames.length;
            if (frameSouth < 40 || frameSouth == 50){
                frameSouth = 40;
            }
        }
    }
    private void animateWalkEast() {
        setImage(frames[frameEast]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameEast = (frameEast + 1) % frames.length;
            if (frameEast < 70 || frameEast == 80){
                frameEast = 70;
            }
        }
    }
    private void animateWalkWest() {
        setImage(frames[frameWest]);
        delayCount++;
        if (delayCount >= frameDelay) {
            delayCount = 0;
            frameWest = (frameWest + 1) % frames.length;
            if (frameWest < 50 || frameWest == 60){
                frameWest = 50;
            }
        }
    }
    public void setPlayerHealth(int health) {
        playerHealth = health;
    }
}   

