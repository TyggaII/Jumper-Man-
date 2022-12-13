import greenfoot.*;

/**
 * Actor Class Button: A subclass of Actor used to create clickable objects that display text
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    public static int defaultButtonHeight = 50; // default height of the button image, when unspecified (adjusted by the Menu class)
    public static Color defaultButtonColor = Color.WHITE; // default background color of the button image
    public static Color defaultTextColor = Color.BLACK; // default color of the text in the button image
    public static Color defaultFrameColor = Color.BLACK; // default color for the frame of the button image
    public static int defaultImageAlpha = 192; // default alpha value for the button image
    public static int defaultFrameLineCount = 2; // default number of lines to draw for the frame of the button image
    public static boolean defaultSolidFrame = false; // default frame type (solid or lined)
    public static boolean defaultRounded = true; // default basic shape of the button image (rounded sides or rectangular)
    public static int defaultCircleFactor = 0; // default straightness factor for the side edges of the button image
    public static int selected = -1; // to hold the value of the option button that was clicked
    protected String text = ""; // the text of the button object
    protected Color buttonColor = defaultButtonColor; // the background color of the button object
    protected Color textColor = defaultTextColor; // the color of the button text
    protected int buttonNumber = -1; // the value to return if clicked on (the button number; zero indicates the title object)
    protected boolean mouseOver = false; // a flag stating if mouse is over the button object or not
    protected boolean canClick = true; // a flag to indicate if button is active or not
    protected int imageAlpha = defaultImageAlpha; // the alpha value of the background of the button image
    protected int buttonHeight = defaultButtonHeight; // the height of the button image
    protected int fontSize = defaultButtonHeight * 4 / 5; // the font size of the text to display on the button
    protected int initialButtonWidth = 0; // the initial width of the button
    protected int buttonWidth = 0; // the current width of the button
    protected int frameLineCount = defaultFrameLineCount; // the number of lines to draw for the frame of the button image
    protected Color frameColor = defaultFrameColor; // the current color of the button image frame
    protected boolean solidFrame = defaultSolidFrame; // a flag to indicate frame type (solid or lined)
    protected boolean rounded = defaultRounded; // a flag to indicate button shape (rounded or squared)
    protected int circleFactor = defaultCircleFactor; // the straightness factor for the side edges of button image (minimum: -buttonWidth; maximum: buttonHeight - 13)
    
    
    public Button(String btnText, int btnNumber)
    {
        text = btnText;
        buttonNumber = btnNumber;
        buttonHeight = getLineCount() * defaultButtonHeight;
        updateImage();
        initialButtonWidth = getImage().getWidth();
        buttonWidth = initialButtonWidth;
    }
    
   
    public Button(String btnText, int btnNumber, int textSize, Color txtColor, Color btnColor)
    {
        fontSize = textSize;
        text = btnText;
        buttonNumber = btnNumber;
        textColor = txtColor;
        buttonColor = btnColor;
        updateImage();
        initialButtonWidth = getImage().getWidth();
        buttonWidth = initialButtonWidth;
        setButtonHeight(fontSize * getLineCount());
    }
    
    
    private void updateImage()
    {
        // determine the appropriate settings to use
        int currSize = mouseOver ? buttonHeight + 6 : buttonHeight;
        int fSize = mouseOver ? fontSize  * 7 / 6 : fontSize;
        Color currColor = buttonColor;
        if (buttonNumber == 0 && canClick) currColor = new Color(224, 224, 224);
        if (!canClick) currColor = new Color(160, 160, 160);
        // create the image of the text for the button image
        GreenfootImage txt = new GreenfootImage(text, fSize, textColor, new Color(0, 0, 0, 0));
        // create the main image for the button
        GreenfootImage image = new GreenfootImage(currSize - circleFactor, currSize);
        image.setColor(currColor);
        if (rounded)
        {
            image.fillOval(0, 0, currSize - circleFactor - 1, currSize - 1); // the background color (circle)
            image.setColor(frameColor);
            if (frameLineCount > 1) image.drawOval(2, 2, currSize - circleFactor - 5, currSize - 5); // inner border line of circle
            if (frameLineCount > 0) image.drawOval(0, 0, currSize - circleFactor - 1, currSize - 1); // outer border line of circle
            if (solidFrame && frameLineCount > 0) image.drawOval(1, 1, currSize - circleFactor - 3, currSize - 3); // fill between outer and inner border lines
        }
        else
        {
            image.fill();
            image.setColor(frameColor);
            if (frameLineCount > 1) image.drawRect(2, 2, currSize - 5, currSize - 5); // inner border line of box
            if (frameLineCount > 0) image.drawRect(0, 0, currSize - 1, currSize - 1); // outer border line of box
            if (solidFrame && frameLineCount > 0) image.drawRect(1, 1, currSize - 3, currSize - 3); // fill between outer and inner border lines
        }
        int newW = initialButtonWidth == 0 ? currSize + txt.getWidth() : mouseOver ? buttonWidth * 7 / 6 : buttonWidth; // target width of object image
        while (image.getWidth() < newW) image.scale(image.getWidth() + 1, image.getHeight()); // stretches image width
        while (image.getWidth() > newW) image.scale(image.getWidth() - 1, image.getHeight()); // shrinks image width
        // applies the text image to the main image
        image.drawImage(txt, (image.getWidth() - txt.getWidth()) / 2, (image.getHeight() - txt.getHeight()) / 2);
        image.setTransparency(mouseOver ? 255 : imageAlpha);
        setImage(image);
    }
    
   
    public void act()
    {
        if (!canClick) return; // no cancelling allowed and title object
        if (Greenfoot.mouseClicked(this)) selected = buttonNumber; // record selected (clicked on)
        // control the image dependent on if mouse is over the object or not
        if (!mouseOver && Greenfoot.mouseMoved(this))
        {
            mouseOver = true;
            updateImage();
        }
        if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
        {
            mouseOver = false;
            updateImage();
        }
    }
    
    
    public void deactivate()
    {
            canClick = false;
            updateImage();
    }
    
 
    public void activate()
    {
        canClick = true;
        updateImage();
    }
    
  
    public String getText()
    {
        return text;
    }
    
 
    public void setText(String txt)
    {
        text = txt;
        initialButtonWidth = 0;
        updateImage();
        initialButtonWidth = getImage().getWidth();
        buttonWidth = initialButtonWidth;
    }
    
    
    public int getImageAlpha()
    {
        return imageAlpha;
    }
    
    
    public void setImageAlpha(int alfa)
    {
        if (alfa < 128 || alfa > 255) return;
        imageAlpha = alfa;
        updateImage();
    }
    
    public int getFontSize()
    {
        return fontSize;
    }
    
    public void setFontSize(int fSize)
    {
        if (fSize > buttonHeight || fSize < 10) return;
        fontSize = fSize;
        updateImage();
    }
    

    public void setButtonColor(Color btnColor)
    {
        buttonColor = btnColor;
        updateImage();
    }
    
    
    public void setTextColor(Color txtColor)
    {
        textColor = txtColor;
        updateImage();
    }
    
    
    public int getButtonHeight()
    {
        return buttonHeight;
    }
    
  
    public void setButtonHeight(int btnHeight)
    {
        if (btnHeight < fontSize) return;
        buttonHeight = btnHeight;
        updateImage();
    }
    

    public int getButtonWidth()
    {
        return buttonWidth;
    }
    
 
    public void setButtonWidth(int btnWidth)
    {
        if (btnWidth < initialButtonWidth) return;
        buttonWidth = btnWidth;
        updateImage();
    }
    
 
    public void setFrameLineCount(int lineCt)
    {
        if (lineCt < 0 || lineCt > 2) return;
        frameLineCount = lineCt;
        updateImage();
    }

    public void setFrameColor(Color frmColor)
    {
        frameColor = frmColor;
        updateImage();
    }
    
 
    public void setSolidFrame(boolean isSolid)
    {
        solidFrame = isSolid;
        updateImage();
    }
    
    
    public void setRounded(boolean isRound)
    {
        rounded = isRound;
        updateImage();
    }
    
  
    public void setCircleFactor(int circFactor)
    {
        if (buttonHeight - circFactor < 13 || buttonWidth + circFactor < 0) return;
        circleFactor = circFactor;
        updateImage();
    }
    

    public int getButtonNumber()
    {
        return buttonNumber;
    }
    
  
    public static int getSelected()
    {
        int selection = selected; // saves the value of 'selected' in a local variable
        selected = -1; // resets 'selected'
        return selection; // returns saved value
    }
    

    private int getLineCount()
    {
        int lines = 0;
        String txt = text;
        // since '\n' is used for a 'new line', we count occurances of those (plus one)
        while (txt.indexOf("\n") > -1)
        {
            lines++;
            txt = txt.substring(txt.indexOf("\n") + 2);
        }
        lines++;
        return lines;
    }
}
