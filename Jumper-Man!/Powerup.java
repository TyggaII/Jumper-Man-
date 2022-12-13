import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
import java.util.Random;
/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Entity

{
    private int tries = 0;
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(JumperMan.class))
        {
            JumperMan j=(JumperMan)getOneIntersectingObject(JumperMan.class);
            Random r=new Random();
            int randomNumber = r.nextInt(questions.length);
            String x = JOptionPane.showInputDialog(questions[randomNumber].prompt);
            
            if (x.equals(questions[randomNumber].answer)){
                changeCharacter(j);
                getWorld().removeObject( this );
        }else if (x.equals(null)){
            getWorld().removeObject( this );
        }else{
            j.death();
            
        }
    
    }
    }
    //Question Bank
    String q0 = "How many primitive types are there?\n"
              + "(a)3\n(b)5\n(c)7\n(d)8\n";
    String q1 = "What statement will initalize an array?\n"
              + "(a)int[] A = {}\n(b)int[]A = {1, 2, 3}\n(c)int[]A = (1,2,3)\n(d)int[][] A = {1,2,3}";
    String q2 = "What makes a variable belong to a class instead of each instance of a class?\n"
              + "(a)volatile\n(b)final\n(c)static\n(d)abstract";
    String q3 = "Which loop goes on forever?\n"
              + "(a)for(;)\n(b)for(int i = 0; i <1; i--)\n(c)for(int i = 0;;i++)\n(d)all of the above";
    String q4 = "What is not the use of 'this'keyword in Java?\n"
              +  "(a)Referring to the instance variable when a local variable has the same name\n(b)Passing itself to the method of the same class\n(c)Passing itself to another method\n(d)Calling another constructor in constructor chaining";
    String q5 = "Which one is true about a constructor?\n"
              + "(a) A constructor must have the same name as the class it is declared within.\n(b)A constructor is used to create objects.\n(c) A constructor may be declared private\n(d)All of the above\n";
    String q6 = "Which of the following is FALSE about arrays on java\n"
              + "(a)A java array is always an object\n(b)Length of array can be changed after creation of array\n(c)Arrays in Java are allocated on heap.";
    //String q7 = "        
        Question [] questions = {
        new Question(q0, "d"),
        new Question(q1, "b"),
        new Question(q2, "c"),
        new Question(q3, "d"),
        new Question(q4, "c"),
        new Question(q5, "d"),
        new Question(q6, "b") 
    };  
      

    
    public int lifespan()
        {
            return 0;
        }
        public void changeCharacter(JumperMan j){
            
    }
}

