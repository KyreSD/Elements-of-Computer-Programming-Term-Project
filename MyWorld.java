import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private Placeholder placeholder;
    CooldownDisplay cooldownDisplaySword, cooldownDisplayFireball;
    public MyWorld()
    {    
        super(600, 400, 1); 
        placeholder = new Placeholder("FullSheetBoy.png", 4, 5);
        Enemy enemy = new Enemy();
        Punchingbag bag = new Punchingbag();
        addObject(placeholder, 300, 200);
        addObject(bag, 400, 200);
        cooldownDisplaySword = new CooldownDisplay("Sword Cooldown: 0");
        cooldownDisplayFireball = new CooldownDisplay("Fireball Cooldown: 0");
        addObject(cooldownDisplaySword, getWidth()/6, 10);
        addObject(cooldownDisplayFireball, getWidth()*3/6, 10);
        addObject(new Enemy(), 400, 200);
        addObject(new Enemy(), 400, 100);
        addObject(new Enemy(), 400, 300);
    }
    public void act() {
        cooldownDisplaySword.setText("Sword Cooldown: "  + placeholder.attackTimerSword);
        cooldownDisplayFireball.setText("Fireball Cooldown: " + placeholder.attackTimerFireball);
        //showText("Sword Cooldown: " + placeholder.attackTimerSword, 200, 200);
        //showText("Fireball Cooldown: " + placeholder.attackTimerFireball, 200, 220);
    }
}
