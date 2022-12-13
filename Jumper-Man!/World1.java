import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World1 extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public World1()
    {    
        
        super(5000, 700, 1, false); 
        Greenfoot.start();
        getBackground().setColor(new Color(96, 213, 219));
        getBackground().fill();
        addObject(new Wide(800,270), 0, 680);
        addObject(new WideCobble(60,50), 657, 415);
        addObject(new WideCobble(60,50), 867, 326);
        addObject(new WideCobble(60,50), 760, 381);
        addObject(new WideCobble(80,50), 1030, 326);
        addObject(new PURPLEpc(), 1030,270);
        
        addObject(new Wide(990,270), 970, 680);
        addObject(new Tall(200,100), 1600 , 326);
        addObject(new Tall(200,100), 1800 , 326);
        addObject(new JumperMan(), 90, 100);
        addObject(new Door1(60,100),4600,549);
        addObject(new Wide(990,270), 2500, 680);
        addObject(new Wide(930,270), 3670, 680);
        addObject(new DeathBarrier(9900,20), 409, 720);
        addObject(new REDpc(), 1703,270);
        addObject(new Enemy(80,80), 730, 560);
        addObject(new Enemy(80,80), 1060, 560);
        addObject(new Enemy(80,80), 1400, 560);
        addObject(new Wide(990,270), 4200, 680);
        addObject(new WideCobble(60,50), 4200, 365);
        addObject(new PURPLEpc(), 2498,560);
        addObject(new REDpc(), 4200,310);
        addObject(new Enemy(50,80), 4200, 560);
        addObject(new Enemy(50,80), 3700, 560);
        addObject(new Enemy(80,80), 2900, 560);
        addObject(new Enemy(80,80), 2300, 560);
        addObject(new Enemy(80,80), 2600, 560);
        addObject(new Wide(100,30), 3100, 365);
    }
}
