import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class World3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class World3 extends World
{
    /**
     * Constructor for objects of class World3.
     * 
     */
    public World3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        getBackground().setColor(new Color(96, 213, 219));
        getBackground().fill();
        addObject(new WideCobble(990,80), 0, 680);
        addObject(new JumperMan(), 90, 100);
    }
}