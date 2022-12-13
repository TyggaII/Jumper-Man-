import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class REDpc extends Powerup
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public REDpc(){
        getImage().scale(60, 60);
    }
    public void act()
    {
        super.act();
    }
    public void changeCharacter(JumperMan j)
    {
         if (j.Player_State==2 && j.powerUpCounter != 0){
            j.Player_State=4;
            j.beginPowerup(1000);
        }else{
        j.Player_State = 3;
        j.beginPowerup(500);
    }
        if (j.powerUpCounter == 0){
            j.Player_State = 1;
            
        }
    }
}