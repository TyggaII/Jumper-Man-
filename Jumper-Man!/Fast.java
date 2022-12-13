import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fast extends Projectile
{
    /**
     * Act - do whatever the Fast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        removeFromWorld();
        projectileMove();
    }
        public Fast(){
        getImage().scale(50, 50);
    }
    
}
