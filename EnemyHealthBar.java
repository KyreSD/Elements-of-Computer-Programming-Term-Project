import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Health bar that tracks and displays enemy health.
 * Updated to work directly with Enemy instead of EnemyTracking.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    private GreenfootImage barGreen, barRed;
    private GreenfootImage combinedImage;
    private Enemy enemy = null;
    private int barWidth = 50;
    private int barHeight = 5;
    
    public EnemyHealthBar(){
    }
    
    public void act()
    {   
        if (enemy != null && enemy.getWorld() != null) {
            setLocation(enemy.getX(), enemy.getY() - enemy.frameHeight/3);
            updateHealthBar();
            
            // Remove when enemy health is very low or enemy is removed
            if (enemy.getHealth() <= 0 || enemy.getWorld() == null) {
                getWorld().removeObject(this);
            }
        } else if (getWorld() != null) {
            // Enemy is gone, remove this bar
            getWorld().removeObject(this);
        }
    }
    
    public void setTracker(Enemy tracker){
        enemy = tracker;
    }
    
    public void updateHealthBar(){
        if (enemy == null) return;
        
        int health = enemy.getHealth();
        int maxHealth = enemy.getMaxHealth();
        
        // Create the bar images
        barGreen = new GreenfootImage(barWidth, barHeight);
        barRed = new GreenfootImage(barWidth, barHeight);
        
        barGreen.setColor(Color.GREEN);
        barGreen.fillRect(0, 0, barWidth, barHeight);
        
        barRed.setColor(Color.RED);
        barRed.fillRect(0, 0, barWidth, barHeight);
        
        // Calculate the green portion width based on health percentage
        int greenWidth = (int)(((double)health / maxHealth) * barWidth);
        
        // Create a combined image
        combinedImage = new GreenfootImage(barWidth, barHeight);
        combinedImage.drawImage(barRed, 0, 0);
        
        // Draw the green portion on top of red
        GreenfootImage healthPortion = new GreenfootImage(greenWidth, barHeight);
        healthPortion.setColor(Color.GREEN);
        healthPortion.fillRect(0, 0, greenWidth, barHeight);
        
        combinedImage.drawImage(healthPortion, 0, 0);
        setImage(combinedImage);
    }
}
