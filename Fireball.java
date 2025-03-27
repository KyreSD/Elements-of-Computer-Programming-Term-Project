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
    int damage;
    int damageCheck = 0;
    boolean canTurn = true;
    private void spawnSlashes(int x, int y) {
        if (slashes == null) {
            int slashCount = 0;
            slashes = new Slashes();
            getWorld().addObject(slashes, x, y);
        }
    }
    public Fireball(){
        setImage("fireball.png");
        scaleImage(getImage(), 50, 50);
        if (canTurn == true){
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
            canTurn = false;
        }
    }
    public int fireballLocationX(){
        return getX();
    }
    public int fireballLocationY(){
        return getY();
    }
    public void updateDamage() {
        if (getWorld() != null) {
            damage = ((MyWorld) getWorld()).damageFireball;
        }
    }
    public void addedToWorld(World world) {
        updateDamage();
    }
    public void act()
    {
        System.out.println("Fireball damage is " + damage);
        Enemy enemy = (Enemy)getOneIntersectingObject(Enemy.class);
        Punchingbag bag = (Punchingbag)getOneIntersectingObject(Punchingbag.class);
        if (enemy != null){
            enemy.health = enemy.health - damage;
            if(enemy.health >= 0){
                spawnSlashes(getX(),getY());
                getWorld().removeObject(this);
                if(enemy.health <= 0){
                    getWorld().removeObject(enemy);
                }
            }
        }
        if (bag != null){    
            damageCheck += damage;
            spawnSlashes(getX(),getY());
            getWorld().removeObject(this);
            //System.out.println(damageCheck);
        }
        move(2);
        if (canTurn == true){
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
            canTurn = false;
        }
    }
    private void scaleImage(GreenfootImage img, int width, int height) {
        img.scale(width, height);
    }
}
