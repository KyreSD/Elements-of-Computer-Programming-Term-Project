// PlayerHealthBar.java - Updated to use percentage-based health calculations
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A health bar that displays the player's current health as a percentage of maximum health.
 */
public class PlayerHealthBar extends Actor
{
    private PlayerOne player;
    
    /**
     * Create a new health bar for the specified player.
     */
    public PlayerHealthBar(PlayerOne player) {
        this.player = player;
        updateHealthBar(); // Set initial health bar image
    }
    
    /**
     * Act - update the health bar based on player's current health.
     */
    public void act()
    {
        if (player != null) {
            updateHealthBar();
        }
    }
    
    /**
     * Update the health bar image based on player's current health percentage.
     */
    private void updateHealthBar() {
        int currentHealth = player.getHealth();
        CheckHealth(currentHealth);
    }
    
    /**
     * Set the correct health bar image based on health percentage relative to max health.
     */
    public void CheckHealth(int currentHealth) {
        int maxHealth = player.getMaxHealth();
        int healthPercentage = (currentHealth * 100) / maxHealth;
        
        if(healthPercentage > 90) {
            setImage("full100.png");
        } else if(healthPercentage > 80) {
            setImage("health90.png");
        } else if(healthPercentage > 70) {
            setImage("health80.png");
        } else if(healthPercentage > 60) {
            setImage("health70.png");
        } else if(healthPercentage > 50) {
            setImage("health60.png");
        } else if(healthPercentage > 40) {
            setImage("health50.png");
        } else if(healthPercentage > 30) {
            setImage("health40.png");
        } else if(healthPercentage > 20) {
            setImage("health30.png");
        } else if(healthPercentage > 10) {
            setImage("health20.png");
        } else if(healthPercentage > 0) {
            setImage("health10.png");
        } else {
            setImage("health0.png");
        }
    }
    
    /**
     * Update the player reference if needed.
     */
    public void setPlayer(PlayerOne player) {
        this.player = player;
    }
}
