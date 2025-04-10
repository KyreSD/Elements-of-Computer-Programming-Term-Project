import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class World2 extends SuperWorld {

    private Placeholder placeholder;
    private Enemy enemy = new Enemy();
    XpDropped exp;
    //weapon damage variables
    int damageSword = 1;
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
    public World2() {    

        placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        addObject(placeholder, 300, 200);
        Sword sword = new Sword(6, 1);
        Fireball fireball = new Fireball();
        Slashes slashes = new Slashes();
    }    

    // Constructor to transition player with health
    public World2(int xp, int health, int playerX, int playerY) {
        GreenfootImage background = new GreenfootImage("DarkGrass2.png");
        background.scale(600, 400);
        setBackground(background);
        
        playerHealth = health;
        Placeholder newPlayer = new Placeholder("FullSheetBoy.png", 4, 5);
        addObject(newPlayer, playerX, playerY);
        newPlayer.setPlayerHealth(playerHealth);
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
        Sword sword = new Sword(6, 1);
        Fireball fireball = new Fireball();
        Slashes slashes = new Slashes();
    }
}
