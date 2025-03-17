import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Slashes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Slashes extends Actor
{
    /**
     * Act - do whatever the Slashes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int animationFrame = 0;
    private String[] swingImages = {
        "SlashesFile1.png","SlashesFile2.png","SlashesFile3.png",
        "SlashesFile4.png","SlashesFile5.png","SlashesFile6.png",
        "SlashesFile7.png","SlashesFile8.png","SlashesFile9.png",
        "SlashesFile10.png","SlashesFile11.png","SlashesFile12.png",
        "SlashesFile13.png","SlashesFile14.png","SlashesFile15.png",
        "SlashesFile16.png","SlashesFile17.png","SlashesFile18.png",
        "SlashesFile19.png","SlashesFile20.png",
        "nothing.png"
    };
    private int frameDelay = 2; 
    private int delayCounter = 0;
    private boolean isAnimating = false;
    int damage;
    int damageCheck = 0;
    public void updateDamage() {
        if (getWorld() != null) {
            damage = ((MyWorld) getWorld()).damageSlashes;
        }
    }
    public void addedToWorld(World world) {
        updateDamage();
    }
    public void act()
    {
        System.out.println("Slash damage is " + damage);
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        EnemyTracking enemyTrack = (EnemyTracking)getOneIntersectingObject(EnemyTracking.class);
        Punchingbag bag = (Punchingbag)getOneIntersectingObject(Punchingbag.class);
        if (enemy != null){
            enemy.health = enemy.health - damage;
            if (enemyTrack != null){
                enemyTrack.move(-1);
                enemyTrack.health -= damage;
                if(enemyTrack.health <= 0){
                    getWorld().removeObject(enemyTrack);
                }
            }
            if(enemy.health <= 0){
                getWorld().removeObject(enemy);
            }
        }
        if (bag != null){    
            damageCheck += damage;
            System.out.println(damageCheck);
        }
        handleAnimation();
    }
    private void handleAnimation() {
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (!isAnimating) {
            isAnimating = true; 
            animationFrame = 0; 
            delayCounter = frameDelay; 
        }

        if (isAnimating) {
            if (delayCounter == 0) {
                setImage(swingImages[animationFrame]); 
                scaleImage(getImage(), 200, 200); 
                animationFrame++; 

                if (animationFrame >= swingImages.length) {
                    isAnimating = false; 
                    animationFrame = 0; 
                    getWorld().removeObject(this);
                    if (enemy != null){
                        enemy.move(2);
                    }
                }delayCounter = frameDelay;
                
            } else {
                delayCounter--; 
            }
        }
    
    }
    private void scaleImage(GreenfootImage img, int width, int height) {
        img.scale(width, height);
    }
}
