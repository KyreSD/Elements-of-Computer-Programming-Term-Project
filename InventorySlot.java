import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class in here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InventorySlot extends Actor
{
    /**
     * Act - do whatever the in wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Actor currentWeapon;
    public InventorySlot(){
        getImage().scale(50,50);
        setImage("inventory slot.png");
        getImage().scale(65,65);
        currentWeapon = null;
        getImage().scale(50,50);
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("1")){
            equipWeapon(new NonInteractiveSword());
        }else if(Greenfoot.isKeyDown("2")){
            equipWeapon(new Enemy());
        }
    }

    public void equipWeapon(Actor weapon){
        if(currentWeapon != null){
            getWorld().removeObject(currentWeapon);
        }
        getWorld().addObject(weapon, 300, 375);
        currentWeapon = weapon;
    }
}
