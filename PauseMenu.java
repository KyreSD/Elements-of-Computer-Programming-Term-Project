/**
 * Write a description of class PauseMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class PauseMenu extends World 
{
   private void showPauseMenu() {
       GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
       background.setColor(Color.WHITE);
       background.fill();
       setBackground(background);
       int centerX = getWidth() / 2;
       int centerY = getHeight() / 2;
       //Button location 
       addObject(new ResumeButton(gameWorld), centerX, centerY - 70);
       addObject(new SaveGameButton(), centerX, centerY);
       addObject(new LoadSaveButton(), centerX, centerY +70);
       addObject(new SettingsButton(gameWorld), centerX, centerY + 140);
   }
    
   private MyWorld gameWorld;
   public PauseMenu(MyWorld gameWorld) {
       super(600, 400, 1);
       this.gameWorld = gameWorld;
       showPauseMenu();
   }
   
   
}
