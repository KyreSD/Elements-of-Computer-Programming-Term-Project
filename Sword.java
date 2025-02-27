import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int animationFrame = 0;
    private String[] swingImages = {
        "swordFile1.png", "swordFile2.png", "swordFile3.png",
        "swordFile4.png", "swordFile5.png", "swordFile6.png"
    };
    private int frameDelay = 2; // Adjust this for animation speed
    private int delayCounter = 0;
    private boolean isAnimating = false;
    
    public void act()
    {
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (enemy != null){
            System.out.println(enemy);
            enemy.health = enemy.health - 1;
            enemy.move(-5);
            System.out.println("Health start");
            System.out.println(enemy.health);
            if(enemy.health <= 0){
                getWorld().removeObject(enemy);
            }
        }
        handleAnimation();
    }
    /**private void handleAnimation() {
        if (Greenfoot.isKeyDown("right")) {
            if (Greenfoot.isKeyDown("w")){
                setRotation(270);
            } else if (Greenfoot.isKeyDown("a")){
                setRotation(180);
            } else if (Greenfoot.isKeyDown("s")){
                setRotation(90);
            } else if (Greenfoot.isKeyDown("d")){
                setRotation(0);
            } else setRotation(0);
            if (delayCounter == 0) {
                setImage(swingImages[animationFrame]); // Set image
                scaleImage(getImage(), 200, 200); // Scale it to 100x100 (adjust as needed)
                animationFrame++;
                if (animationFrame >= swingImages.length) {
                    animationFrame = 0; // Reset animation
                }
                delayCounter = frameDelay;
            } else {
                delayCounter--; // Countdown
            }
        } else {
            animationFrame = 0; // Reset animation when not swinging
        }
    }**/
    
    private void handleAnimation() {
        if (!isAnimating && Greenfoot.isKeyDown("right")) {
            isAnimating = true; // Start animation
            animationFrame = 0; // Reset frame index
            delayCounter = frameDelay; // Reset delay timer
        }

        if (isAnimating) {
            if (Greenfoot.isKeyDown("w")){
                setRotation(270);
            } else if (Greenfoot.isKeyDown("a")){
                setRotation(180);
            } else if (Greenfoot.isKeyDown("s")){
                setRotation(90);
            } else if (Greenfoot.isKeyDown("d")){
                setRotation(0);
            } else setRotation(0);
            if (delayCounter == 0) {
                setImage(swingImages[animationFrame]); // Set current frame
                scaleImage(getImage(), 100, 100); // Scale image
                animationFrame++; // Move to next frame

                if (animationFrame >= swingImages.length) {
                    isAnimating = false; // Stop animation after last frame
                    animationFrame = 0; // Reset for next use
                }delayCounter = frameDelay;
                // Reset delay timer for next frame
            } else {
                delayCounter--; // Countdown delay before switching frames
            }
        }
    }

    private void scaleImage(GreenfootImage img, int width, int height) {
        img.scale(width, height);
    }
    
}
