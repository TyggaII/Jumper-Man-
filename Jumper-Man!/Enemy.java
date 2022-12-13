import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Entity
{
    int speed = -3;
    int count = 0;
    private String answer;  
        public Enemy(int width, int height){
        getImage().scale(width, height);
    }
    /*
     * Act - do whatever the snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void Enemy(String z)
    {
         
    }
    public void act()
    {
        count++;
        moveAround();
        hitByProjectile();        
    }
    public void hitByProjectile()
    {
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if (projectile != null)
        {
            getWorld().removeObject(projectile);
            getWorld().removeObject(this);
            
        }
        
    }
    public void moveAround()
    {
       if (count <60){
       setLocation(getX() + speed, getY());
    }
       else{
       speed = - speed;
       getImage().mirrorHorizontally();  
       count=0;
    }
    }

}


    

