import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Slashes slashes;
    boolean canTurn = false;
    private void spawnSlashes(int x, int y) {
        if (slashes == null) {
            int slashCount = 0;
            slashes = new Slashes();
            getWorld().addObject(slashes, x, y);
        }
    }
    public int fireballLocationX(){
        return getX();
    }
    public int fireballLocationY(){
        return getY();
    }
    public void act()
    {
        setImage("fireball.png");
        scaleImage(getImage(), 50, 50);
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        if (enemy != null){
            enemy.health = enemy.health - 1;
            System.out.println(enemy.health);
            if(enemy.health >= 0){
                spawnSlashes(getX(),getY());
                getWorld().removeObject(this);
                if(enemy.health <= 0){
                    getWorld().removeObject(enemy);
                }
            }
        }
        move(2);
        System.out.println(canTurn);
        if (!canTurn){
            if (Greenfoot.isKeyDown("w")) {
                setRotation(-90);
                canTurn = false;
            } if (Greenfoot.isKeyDown("a")) {
                setRotation(-180);
                canTurn = false;
            } if (Greenfoot.isKeyDown("s")) {
                setRotation(90);
                canTurn = false;
            } if (Greenfoot.isKeyDown("d")) {
                setRotation(0);
                canTurn = false;
            }
        }
    }
    private void scaleImage(GreenfootImage img, int width, int height) {
        img.scale(width, height);
    }
}
