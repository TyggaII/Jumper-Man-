import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Set;

/**
 * Write a description of class WideScroll here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WideScroll extends Actor
{
    /**
     * Act - do whatever the WideScroll wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   boolean start = Greenfoot.isKeyDown("space");
   private int timer = 1;
    public void act()
    {
        scroll();
        timer++;
}
    public void scroll(){
        if(timer > 0){
            setLocation(getX() - 5, getY());
        }
       
        
}
}