import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Question here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    String prompt;
    String answer;
    /**
     * Act - do whatever the Question wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Question(String prompt, String answer){
        this.prompt=prompt;
        this.answer=answer;
    }
                  
    public void act()
    {
        // Add your action code here.
    }
}
