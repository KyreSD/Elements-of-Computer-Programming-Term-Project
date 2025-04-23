import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int size;
    int speed;
    int damage;
    int doItOnce;
    int rotation;
    PlayerOne player;
    ProjectileText blop;
    
    public Projectile(int damage, int speed, int size){
       GreenfootImage image = new GreenfootImage("Projectile.png");
        image.scale(size, size);
        this.speed = speed;
        setImage(image); 
        blop = new ProjectileText(damage, speed, size);
        doItOnce = 0;
        this.damage = damage;
    }
    
    public void act()
    {
        player = (PlayerOne)getWorld().getObjects(PlayerOne.class).get(0);
        if(doItOnce == 0){
            getWorld().addObject(blop, getX(), getY());
            turnTowards(player.getX(), player.getY());
            rotation = getRotation();
            doItOnce = 1;
        }
        setRotation(rotation);
        move(speed);
        setRotation(0);
        
        
        blop.setLocation(getX()+size+25, getY()+12);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }  
    }
}
