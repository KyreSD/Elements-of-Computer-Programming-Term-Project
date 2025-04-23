import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProjectileText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProjectileText extends Actor

{
    int damage;
    int size;
    int speed;
    int counter;
    /**
     * Act - do whatever the ProjectileText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ProjectileText(int damage, int size, int speed){
        this.damage = damage;
        this.size = size;
        this.speed = speed;
        counter=1;
    }
    
    public void act()
    {
        setImage(new GreenfootImage(damage+"\n"+size+"\n"+speed, 20, Color.BLACK, null));
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        counter+=1;
        if(counter>80){
            getWorld().removeObject(this);
        }
    }
}
