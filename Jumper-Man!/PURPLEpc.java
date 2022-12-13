import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Size here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PURPLEpc extends Powerup
{
        public PURPLEpc(){
        getImage().scale(60, 60);
    }
    /**
     * Act - do whatever the Size wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }

    public void changeCharacter(JumperMan j)
    {
        if (j.Player_State==3 && j.powerUpCounter != 0){
            j.Player_State=4;
            j.beginPowerup(1000);
        }else{
        j.Player_State=2;
        j.beginPowerup(500);
    }
        if (j.powerUpCounter == 0){
            j.Player_State = 1;
        }
        
    }
}
