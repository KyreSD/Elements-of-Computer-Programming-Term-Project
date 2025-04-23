// Weapon.java
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for all weapons that can scale with player level
 */
public class Weapon extends Actor
{
    public int baseDamage;  // Base damage value
    public int damage;      // Current damage (scales with level)
    public int level;       // Current level
    
    /**
     * Update weapon damage based on player level
     */
    public void updateDamage(int playerLevel) {
        level = playerLevel;
        // Damage increases by 8% per level
        damage = (int)(baseDamage * (1 + (0.08 * level)));
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
