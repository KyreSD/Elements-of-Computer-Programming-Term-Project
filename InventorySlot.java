import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class in here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventorySlot extends Actor
{
    public Actor currentWeapon;
    /**
     * Act - do whatever the in wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public InventorySlot(){
        setImage("inventory slot.png");
        getImage().scale(65,65);
        currentWeapon = null;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("1")){
            Sword sword = new Sword();
            getWorld().addObject(sword,300,375);
            currentWeapon = sword;
        } else if (Greenfoot. isKeyDown("2")){
            Enemy enemy = new Enemy();
            getWorld().addObject(enemy, 300, 375);
            currentWeapon = enemy;
        }
    }
}
