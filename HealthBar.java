import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health;
    private GreenfootImage barGreen,barRed;
    private GreenfootImage combinedImage;
    private EnemyTracking enemyTrack = null;
    public void act()
    {   
        Enemy enemyLocation = new Enemy();
        if (enemyTrack != null) {
            setLocation(enemyTrack.getX(), enemyTrack.getY() - enemyLocation.frameHeight/3);
            health = enemyTrack.health;
        } else {
            getWorld().removeObject(this);
        }
        if (health <= 0){
            getWorld().removeObject(this);
        }
        updateHealthBar();
    }
    public void setTracker(EnemyTracking tracker){
        enemyTrack = tracker;
    }
    public void updateHealthBar(){
        barGreen = new GreenfootImage("HealthBarGreen.png");
        barRed = new GreenfootImage("HealthBarRed.png");
        barGreen.scale(200,5);
        barRed.scale(200,5);
        combinedImage = new GreenfootImage(barGreen.getWidth(), barGreen.getHeight());
        combinedImage.drawImage(barGreen, 0, 0);
        combinedImage.drawImage(barRed, health, 0);
        combinedImage.scale(50,5);
        setImage(combinedImage);
    }
}
