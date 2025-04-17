import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickoutWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakoutWorld extends World
{

    /**
     * Constructor for objects of class BrickoutWorld.
     * 
     */
    private GreenfootSound music;
    int brickPlace = 25; 
    int brickY=50;
    public BreakoutWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 800, 1);
        
        //music = new GreenfootSound("music.mp3");
        //music.setVolume(40);
        
        PlayerOne player = new PlayerOne();
        BreakoutRasamny rasamny = new BreakoutRasamny();
        addObject(player,300, getHeight()-80);
        addObject(rasamny, 400, 153);
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


