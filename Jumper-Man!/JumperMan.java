import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
* Write a description of class JumperMan here.
* 
* @author (your name) 
* @version (a version number or a dateb)
*/

public class JumperMan extends Entity
{
  
    public int powerUpCounter;
    private boolean canFire;
    public int Health = 100;
    public int jumpStrength = -38;
    
    public int Player_State = 1;

 
    
    public void act()
        {
       checkBounds();
       checkFall();
       Jump();
       moveAround();
       Win();
       getHit(); 
       fireProjectile();
       processPowerup();
       if (powerUpCounter == 0){
           Player_State = 1;
        }
       switch (Player_State) {
        case 1: //NormalMan
        DefAbilities();
        break;
        case 2://JumperMan
        setFire(false);
        setJumpStrength(-50);
        break;
        case 3://FireMan
        fireProjectile();
        case 4:
            fireProjectile();
            setJumpStrength(-50);        
        break;
        
        }   
        }
    public void setJumpStrength(int s){
    
        jumpStrength = s;
        
    }
    public void beginPowerup(int time)
    {
        powerUpCounter = time;
    }
    public void DefAbilities()
        {
            powerUpCounter = 0;
            setFire(false);
            setJumpStrength(-42);
        }
    public void setFire(boolean s){
            canFire = s;
        }
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + speed, getY());    
        }
         if(Greenfoot.isKeyDown("a") && !isDown)
        {
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
            isDown = true;
        }
        if(!Greenfoot.isKeyDown("a") && isDown)
        {
            isDown = false;
            GreenfootImage img = getImage();
            img.mirrorHorizontally();
            setImage(img);
        }
        if(Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - speed, getY());
        }
        if(Greenfoot.isKeyDown("w"))
        {
            Jump();
        }
    }
    public void fireProjectile(){
        if (Greenfoot.isKeyDown("j") && canFire == true && powerUpCounter > 0)
        {
            getWorld().addObject(new Fast(),getX(),getY() -30);
            canFire = false;
    }else if (!Greenfoot.isKeyDown("j") && powerUpCounter > 0)
    {  
        canFire = true;

    }else{canFire = false;
    }
    }
        public void Jump()
    {
        if (Greenfoot.isKeyDown("space") && (onPlatform() || onPlatformtoo()))
        {  
            vSpeed = jumpStrength;  
            Fall();  
        }  
    } 
        public void Win()
    {
        if (isTouching(Door1.class)){
            Greenfoot.setWorld(new World2());
        }
    }
    public void getHit()
    {
            if (isTouching(Enemy.class) && Health != 0){
            Health-=5;}
            else if(isTouching(Enemy.class) && Health == 0){
            setLocation(90, 100);
            Health = 100;
            death();
        }                
    }
        public void checkBounds()
    {
            if (isTouching(DeathBarrier.class) ) {
            death();   
        }
    }
        public void death()
    {
        if (deaths != 3){
        setLocation(90, 100);
        Health += 100;
        deaths++;
            }
        if (isTouching(Enemy.class) && deaths == 3 || deaths == 3){
                    Greenfoot.setWorld(new TitleScreen());
                    deaths = 0;
                }
    }  
        public void processPowerup()
        {
            if(powerUpCounter > 0)
            {
                powerUpCounter--;
                if (powerUpCounter == 0 && Player_State !=3)
                {
                    canFire = false;
                }
            }
    }
        public void beginPowerUp(int time)
    {
            powerUpCounter = time;
    }
}








 
