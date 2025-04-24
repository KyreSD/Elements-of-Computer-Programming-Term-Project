import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickoutWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakoutWorld extends SuperWorld
{

    /**
     * Constructor for objects of class BrickoutWorld.
     * 
     */
    
    private GreenfootSound music;
    int brickPlace = 25; 
    int brickY=50;
    PlayerOne player; 
    public BreakoutWorld(PlayerOne player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        
        super(player, 800, 800, 1);
        player.WorldType = WORLDSTATE.BOSSONE;
        this.player = player;
        //music = new GreenfootSound("music.mp3");
        //music.setVolume(40);
        
        BreakoutRasamny rasamny = new BreakoutRasamny(player);
        addObject(rasamny, 400, 133);
        for(brickPlace=25; brickPlace < 800;brickPlace+=50){
            for(brickY=250; brickY<350;brickY+=20){
                addObject(new Brick(), brickPlace, brickY);
            }
        }
    addObject(new HandLeft(), 471, 233);
    addObject(new HandRight(), 320, 233);
}

public void act(){
    
        //music.playLoop();
    }
    

}


