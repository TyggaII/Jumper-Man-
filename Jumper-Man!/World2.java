import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World2 extends World
{

    /**
     * Constructor for objects of class World2.
     * 
     */
       public World2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(3000, 700, 1, false); 
        getBackground().setColor(new Color(96, 213, 219));
        getBackground().fill();
        addObject(new WideCobble(990,80), 0, 680);
        addObject(new WideCobble(990,80), 970, 680);
        addObject(new Tall(200,100), 1600, 365);
        addObject(new JumperMan(), 90, 100);
        addObject(new Wide(990,270), 2500, 680);
        
        addObject(new Enemy(1,1), 420, 524);
        addObject(new DeathBarrier(9900,20), 409, 720);
        
    }
    
}