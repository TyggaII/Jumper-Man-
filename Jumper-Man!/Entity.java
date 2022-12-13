import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entity extends Actor
{
    public int vSpeed = 0;
    public int acceleration = 3;
    public int speed = 5;
    
    public boolean isDown = false;
    public boolean spacePress = false;
    private int gravity= 0;
    public int deaths = 0;
    public int amount = 25;
    /**
     * Act - do whatever the Enity wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
        public void act()
        {
        checkFall();
        onPlatform();
        onPlatformtoo();
        }
          public void checkFall()  
        {  
            if (onPlatform()||onPlatformtoo())  
            {  
                vSpeed = 0;  
                onPlatform();
                onPlatformtoo();
            }  
            else  
            {  
                Fall();  
            }  
        }
                    public boolean onPlatform()  
        {  
            Actor base = getOneObjectAtOffset (5, getImage().getHeight()/5, Ground.class);
            return base != null;  
        
        }  
                    public boolean onPlatformtoo()  
        {  
            Actor base = getOneObjectAtOffset (5, getImage().getHeight()/3, WideCobble.class);
            return base != null;  
        
        }  
             public void Fall()  
        {  
            setLocation(getX(), getY()+vSpeed);  
            vSpeed = vSpeed + acceleration;

        }  
    }
        
