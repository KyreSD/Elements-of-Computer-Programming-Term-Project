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
    int playerHealth = 100;
    int speed = 2;
    
    Sword sword = new Sword();
    public void act()
    {
        
        if (Greenfoot.isKeyDown("a")){
            setRotation(180);
            move(speed);
    }
    if (Greenfoot.isKeyDown("d")){
            setRotation(0);
            move(speed);
    }
    if (Greenfoot.isKeyDown("w")){
            setRotation(270);
            move(speed);
    }
    if (Greenfoot.isKeyDown("s")){
            setRotation(90);
            move(speed);
    }
    if (Greenfoot.isKeyDown("space")){
            move(speed+1);
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
    if (Greenfoot.isKeyDown("up")){
            getWorld().addObject(sword, getX(), getY());
            sword.setLocation(getX(), getY()-30);
    }else if (Greenfoot.isKeyDown("down")){
            getWorld().addObject(sword, getX(), getY());
            sword.setLocation(getX(), getY()+30);
    }else if (Greenfoot.isKeyDown("left")){
            getWorld().addObject(sword, getX(), getY());
            sword.setLocation(getX()-30, getY());
    }else if (Greenfoot.isKeyDown("right")){
            getWorld().addObject(sword, getX(), getY());
            sword.setLocation(getX()+30, getY());
    }else{
        getWorld().removeObject(sword);
    }
}
public void pickUpXP(){
    Placeholder placeholder = (Placeholder)getOneIntersectingObject(Placeholder.class);
        if(isTouching(Placeholder.class)){
            MyWorld world = (MyWorld)getWorld();
            if(world != null){
            world.addXP(5);
            world.removeObject(this);
        }        
}
}
}   
