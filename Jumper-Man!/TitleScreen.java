import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.World;

/**
* Write a description of class TitleScreen here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class TitleScreen extends World
{
static final int WIDE = 400, HIGH = 400; 
// The following are arrays of String text for the menu items
// (the first is the title (which is programatically changed); the rest are the menu options)
String[] menu1 = { "FIRST MENU", "One", "Two", "Three", "Four", "Five", "Six" };
String[] menu2 = { "SECOND MENU", "First", "Second", "Third" };
final int MAX_MENU_CT = 7; // number of example menus displayed in this world
int menuNumber = MAX_MENU_CT - 1; // used to rotate through the menus
Menu menu = null; // to hold the current menu object
private int timer = 200;
/**
 * Constructor for objects of class TitleScreen.
 * 
 */
public TitleScreen()
{    
    super(600, 400, 1, false);
    started();
    act();
    addObject(new WideScroll(), 380, 380);
    addObject(new WalkerMan(), 90, 210);
    getBackground().setColor(new Color(96, 213, 219));
    getBackground().fill();
    
}
 public void started()
{
    menu = null;
    menuNumber = MAX_MENU_CT - 1;
    Button.defaultButtonHeight = 15;
    Button.defaultRounded = false;
    Button.defaultTextColor = Color.RED;
    Button.defaultButtonColor = Color.CYAN;
    Button.defaultSolidFrame = true;
    String[] btnText = { "Start", "Quit" };
    Button[] buttons = new Button[btnText.length];
    int maxWide = 0;
    for (int i = 0; i < btnText.length; i++)
    {
        if (i != 1) buttons[i] = new Button(btnText[i], i + 20); else buttons[i] = new DelayButton(btnText[i], i + 20, 3, true);
        addObject(buttons[i], 51 + 99 * i, 18);
        maxWide = (int) Math.max(maxWide, buttons[i].getButtonWidth());
    }
    for (int i = 0; i < buttons.length; i++) buttons[i].setButtonWidth(maxWide);
}

public void act()
{
    int selection = Button.getSelected();

           // from the world class you can ...
         String text  = ("By: The Super Conductors!");  // Greenfoot is on second line
          // Image of Text is 18 font size, White Text, Blue background 
          GreenfootImage  ImageText = new GreenfootImage(text, 18, Color.WHITE,Color.BLUE); 
          GreenfootImage bg = getBackground();
          bg.drawImage(ImageText, 50 ,30); // upper left corner of image is at 1,1.
String Title  = ("Jumper-man Quest");  // Greenfoot is on second line
          // Image of Text is 18 font size, White Text, Blue background 
          GreenfootImage  ImageTitle = new GreenfootImage(Title, 30, Color.GREEN,Color.BLACK); 
        
          bg.drawImage(ImageTitle, 300 ,30); 
    scroll();
    switch (selection)
    {
        
        case 20: // 'Credits'
        case 21: // 'Start'
            Greenfoot.setWorld(new World1());
        case 22: // 'Options'
            Greenfoot.stop();

        default:
             
    }
   
    }
    

public void scroll(){
timer--;
    if (timer == 160) {
        addObject(new WideScroll(), 1120, 380);
        timer += 180;// pause the execution of the program if 'timer' is less than6 or equal to 0
}
}
}
