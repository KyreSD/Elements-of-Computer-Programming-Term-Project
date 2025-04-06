import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends SuperWorld
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    private Placeholder placeholder;
    private Enemy enemy = new Enemy();
    XpDropped exp;
    //weapon damage variables
    int damageSword;
    int damageFireball = 1;
    int damageSlashes = 2;
    //weapons news
    Sword sword = new Sword(6, 1);
    Fireball fireball = new Fireball();
    Slashes slashes = new Slashes();
    //CooldownDisplays
    CooldownDisplay cooldownDisplaySword, cooldownDisplayFireball;
    DamageUI damageUISword, damageUIFireball, damageUISlashes, levell;
    //xps
    public int xp;
    public int level;
    public int xpThreshold;
    int playerHealth;
    public MyWorld(int xp, int health, int playerX, int playerY)
    {    
        
        /**placeholder, enemies, bag things**/
        placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        /*Enemy enemy = new Enemy();
        EnemyTracking trackEnemy = new EnemyTracking();*/
        for (int x = 0; x < 3; x++) {
            Enemy enemy = new Enemy();
            EnemyTracking trackEnemy = new EnemyTracking();
            HealthBar heba = new HealthBar();
            addObject(enemy, 400, 100 + (x*100));
            addObject(trackEnemy, 400, 100 + (x*100));
            addObject(heba, 400, 100 + (x*100));
            enemy.setTracker(trackEnemy);
            heba.setTracker(trackEnemy);
        }
        exp = new XpDropped();
        Punchingbag bag = new Punchingbag();
        addObject(placeholder, playerX, playerY);
        /*for (int x = 0; x < 3; x++){
            addObject(new Enemy(), 400, 100 + (x*100));
            addObject(new EnemyTracking(), 400, 100 + (x*100));
        }*/
        addObject(bag, 400, 200);
        //portal
        //addObject(new Portal(), 100, 350);
        
        /**cooldown and damage UIs**/
        cooldownDisplaySword = new CooldownDisplay("Sword Cooldown: 0");
        cooldownDisplayFireball = new CooldownDisplay("Fireball Cooldown: 0");
        damageUISword = new DamageUI("Sword damage: 0");
        damageUIFireball = new DamageUI("Fireball damage: 0");
        damageUISlashes = new DamageUI("Slashes damage: 0");
        addObject(cooldownDisplaySword, getWidth()/6, 10);
        addObject(cooldownDisplayFireball, getWidth()/2, 10);
        addObject(damageUISword, getWidth()/6, 30);
        addObject(damageUIFireball, getWidth()/2, 30);
        addObject(damageUISlashes, getWidth()*5/6, 30);
        
        /**Level things**/
        levell = new DamageUI("level: 1");
        addObject(levell, getWidth()*5/6, 10);
        
        /**Level up test**/
        for (int x = 0; x <= 7; x++){
            addObject(new XpDropped(),350 + (x*25),200);
        }
        
        /**extra**/
        xp=0;
        level = 1;
        xpThreshold = 15;
    }
    
    
    public void act() {
        cooldownDisplaySword.setText("Sword Cooldown: "  + placeholder.attackTimerSword);
        cooldownDisplayFireball.setText("Fireball Cooldown: " + placeholder.attackTimerFireball);
        damageUISword.setText("Sword damage: " + damageSword);
        damageUIFireball.setText("Fireball damage: " + damageFireball);
        damageUISlashes.setText("Slashes damage: " + damageSlashes);
        levell.setText("Level: " + level);
        //showText("Sword Cooldown: " + placeholder.attackTimerSword, 200, 200);
        //showText("Fireball Cooldown: " + placeholder.attackTimerFireball, 200, 220);
    }
}
