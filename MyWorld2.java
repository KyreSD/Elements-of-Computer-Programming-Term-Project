import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld2 extends World
{
    
    /**
     * Constructor for objects of class MyWorld2.
     * 
     */
    private Placeholder2 player;
    private int xp = 0, level = 1, xpThreshold = 15;
    private int damageSword = 1, damageFireball = 1, damageSlashes = 2;
    private CooldownDisplay cooldownDisplaySword, cooldownDisplayFireball;
    private DamageUI damageUISword, damageUIFireball, damageUISlashes, levelUI;

    public MyWorld2(int xp, int health, int playerX, int playerY) {    
        super(600, 400, 1);
        player = new Placeholder2("FullSheetBoy.png", 4, 5);
        addObject(player, playerX, playerY);
        initializeUI();
        spawnEnemies(3);
    }
    
    private void initializeUI() {
        cooldownDisplaySword = new CooldownDisplay("Sword Cooldown: 0");
        cooldownDisplayFireball = new CooldownDisplay("Fireball Cooldown: 0");
        damageUISword = new DamageUI("Sword damage: 0");
        damageUIFireball = new DamageUI("Fireball damage: 0");
        damageUISlashes = new DamageUI("Slashes damage: 0");
        levelUI = new DamageUI("Level: 1");
        
        addUIElements();
    }
    
    private void addUIElements() {
        int width = getWidth();
        addObject(cooldownDisplaySword, width / 6, 10);
        addObject(cooldownDisplayFireball, width / 2, 10);
        addObject(damageUISword, width / 6, 30);
        addObject(damageUIFireball, width / 2, 30);
        addObject(damageUISlashes, width * 5 / 6, 30);
        addObject(levelUI, width * 5 / 6, 10);
    }
    
    private void spawnEnemies(int count) {
        for (int i = 0; i < count; i++) {
            int yOffset = 100 + (i * 100);
            addEnemy(new Enemy(), new EnemyTracking(), new HealthBar(), 400, yOffset);
        }
    }
    
    private void addEnemy(Enemy enemy, EnemyTracking tracker, HealthBar healthBar, int x, int y) {
        addObject(enemy, x, y);
        addObject(tracker, x, y);
        addObject(healthBar, x, y);
        enemy.setTracker(tracker);
        healthBar.setTracker(tracker);
    }
    
    public void addXP(int amount){
        xp += amount;
        if (xp >= xpThreshold){
            levelUp();
        }
    }
    
    private void levelUp() {
        level++;
        damageSword = level;
        damageFireball = level;
        damageSlashes = level * 2;
        xpThreshold += 15;
    }
    
    public void act() {
        updateUI();
    }
    
    private void updateUI() {
        cooldownDisplaySword.setText("Sword Cooldown: " + player.getAttackTimerSword());
        cooldownDisplayFireball.setText("Fireball Cooldown: " + player.getAttackTimerFireball());
        damageUISword.setText("Sword damage: " + damageSword);
        damageUIFireball.setText("Fireball damage: " + damageFireball);
        damageUISlashes.setText("Slashes damage: " + damageSlashes);
        levelUI.setText("Level: " + level);
    }
}
