  import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ball extends Weapon

{ 
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private boolean hasCollided;
    private GreenfootSound bounceSound;
    private GreenfootSound brickBounceSound;
    private GreenfootSound music;
    public Ball (){
        Random rand = new Random();
        setRotation(35);
        hasCollided = false;
        bounceSound = new GreenfootSound("ballBounce.mp3");
        bounceSound.setVolume(80);
        brickBounceSound = new GreenfootSound("boing.mp3");
        brickBounceSound.setVolume(80);
    }
    public Ball (int rotation){
        Random rand = new Random();
        setRotation(rotation);
        hasCollided = false;
        bounceSound = new GreenfootSound("ballBounce.mp3");
        bounceSound.setVolume(80);
        brickBounceSound = new GreenfootSound("boing.mp3");
        brickBounceSound.setVolume(80);
    }
    
    public void act()
    {
        
        World myWorld = getWorld();
        int width = myWorld.getWidth();
        int height = myWorld.getHeight();
        GreenfootImage image = getImage();
        int radius = image.getWidth()/2;
        int xleft = getX() - radius;
        int xright = getX() + radius;
        int ytop = getY() - radius;
        int ybottom = getY() + radius;
        
        
        if (xleft <= 0 || xright >= width){
            turn(180 - 2*getRotation());
            bounceSound.play();
        }
        
        if (ytop < 0 || ybottom >= height){
            turn(-2*getRotation());
            bounceSound.play();
        }
        
        /*
        if (isTouching(Brick.class)){
            turn(-2*getRotation());
            removeTouching(Brick.class);
        }
        */
        move(6);
        checkplayerCollision();
        checkBrickCollision();
        checkRamRamCollision();
        }
        
        
    public void checkplayerCollision(){
    Sword sword = (Sword)getOneIntersectingObject(Sword.class);
    if (sword != null && !hasCollided){
        turnTowards(sword.getX(), sword.getY());
        turn(180);
        //turn(-2*getRotation());
        hasCollided = true;
        bounceSound.play();
        }
    if (sword == null && hasCollided == true)
        {
            hasCollided = false;
        }
        
    
    }
    
    public void checkBrickCollision(){
        Brick brick = (Brick)getOneIntersectingObject(Brick.class);
        if (brick != null){
            if (getX() < brick.getLeftEdge() || getX() > brick.getRightEdge())
            {
                turn(180);
            }
            else
            {
                turn(-2*getRotation());
            }
            getWorld().removeObject(brick);
            brickBounceSound.play();
        }
        }
        public void checkRamRamCollision(){
        BreakoutRasamny ramRam = (BreakoutRasamny)getOneIntersectingObject(BreakoutRasamny.class);
        if (ramRam != null){
            turn(-2*getRotation());
        }
    }
}
