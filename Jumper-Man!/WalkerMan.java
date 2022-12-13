import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo
/**
 * Write a description of class Walkerman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WalkerMan extends Actor
{
    GifImage myGif = new GifImage("Walkerman.gif");
    /**
     * Act - do whatever the GameO wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(myGif.getCurrentImage());
    } 
}