import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class World2 extends World {

    private Actor playerCharacter;
    private int playerHealth; // Store health as an integer

    // Default constructor
    public World2() {    
        super(600, 400, 1); 
        playerCharacter = new Placeholder("FullSheetBoy.png", 4, 5);
        addObject(playerCharacter, 300, 200);
        
    }    

    // Constructor to transition player with health
    public World2(Actor selectedCharacter, int xp, int health, int playerX, int playerY) {
        super(600, 400, 1);
        playerCharacter = selectedCharacter;
        playerHealth = health;
        if(playerCharacter instanceof Placeholder){
            ((Placeholder)playerCharacter).setPlayerHealth(playerHealth);
        }
        if(playerCharacter instanceof Link){
            ((Link)playerCharacter).setPlayerHealth(playerHealth);
        }
        if(playerCharacter instanceof RetroSprite){
            ((RetroSprite)playerCharacter).setPlayerHealth(playerHealth);
        }
        addObject(playerCharacter, playerX, playerY);
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
    }
}
