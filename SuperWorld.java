import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperWorld extends World
{

    /**
     * Constructor for objects of class SuperWorld.
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
    public SuperWorld()
    {    
        super(600, 400, 1); 
    }
    public void addXP(int amount){
        xp += amount;
        levelUp();
    }
    public void levelUp(){
        if(xp >= xpThreshold){
            level++;
            damageSword *= level;
            damageFireball *= level;
            damageSlashes *= level;
            sword.updateDamage();
            fireball.updateDamage();
            slashes.updateDamage();
            System.out.println("Sword Damage: " + damageSword);
            System.out.println("Fireball Damage: " + damageFireball);
            System.out.println("Slashes Damage: " + damageSlashes);
            xpThreshold +=15;
            System.out.println("New Level: " + level);
        }
    }
}
