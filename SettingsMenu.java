/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SettingsMenu extends World
{
    private void showSettingsMenu() {
        GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
       background.setColor(Color.WHITE);
       background.fill();
       setBackground(background);
       int centerX = getWidth() / 2;
       int centerY = getHeight() / 2;
       //Button Location
       addObject(new SettingsBackButton(settingsWorld), centerX - 250, centerY - 160);
       addObject(new SoundButton(), centerX, centerY);
    }
    
    private MyWorld settingsWorld;
   public SettingsMenu(MyWorld settingsWorld) {
       super(600, 400, 1);
       this.settingsWorld = settingsWorld;
       showSettingsMenu();
   }
}
