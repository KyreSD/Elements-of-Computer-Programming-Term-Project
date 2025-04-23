import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EvilRasamny here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
public class EvilRasamny extends Enemy
{
    /**
     * Act - do whatever the EvilRasamny wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    PlayerOne player;
    int rasamnyHealth;
    int projectileTimer;
    boolean projectileLaunched;
    Projectile projectile;
    int animationCounter;
    int rotation;
    public EvilRasamny(){
        projectileTimer = 150;
        projectileLaunched = true;
        health = 2000;
        animationCounter = 4;
        rotation = 0;
    }
    public void act()
    {
        projectileLaunched = true;
        player = (PlayerOne)getWorld().getObjects(PlayerOne.class).get(0);
        if(isAtEdge()){
            rotation += Greenfoot.getRandomNumber(90)+135;
            setRotation(rotation);
            if(rotation >= 360){
                rotation -= 360;
            }
        }
        setRotation(rotation);
        move(2);
        setRotation(0);
        projectileTimer -= 1;
        if(projectileTimer <= 0){
            projectileLaunched = false;
        }
        if (projectileLaunched == false){
            projectile = new Projectile(Greenfoot.getRandomNumber(20)+20, Greenfoot.getRandomNumber(7)+8, Greenfoot.getRandomNumber(70)+60); 
            getWorld().addObject(projectile, getX(), getY());
            projectileTimer = 150;
        }
        super.checkCombat();
        if (damageDelay > 0) {
            damageDelay--;
        }
        animateSprite();
    }
    
    public void animateSprite(){
            if(rotation <= 90 || rotation > 270){
            setImage("RasamnyRight"+animationCounter/4+".png");
            getImage().scale(100, 200);
        }else{
            setImage("RasamnyLeft"+animationCounter/4+".png");
            getImage().scale(100, 200);
        }
        if(animationCounter >= 4*17+3){
                animationCounter = 4;
        }
        animationCounter+=1;
        }
    }

