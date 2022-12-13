import greenfoot.*;

public class DelayButton extends Button
{
    private int delayTime = 1; 
    private long lastSelectTime = 0; 
    public DelayButton(String txt, int val, int delayAmt, boolean delaying)
    {
        super(txt, val);
        setDelay(delayAmt, delaying);
    }
    public DelayButton(String txt, int val, int txtSize, Color txtColor, Color btnColor, int delayAmt, boolean delaying)
    {
        super(txt, val, txtSize, txtColor, btnColor);
        setDelay(delayAmt, delaying);
    }
    private void setDelay(int delayAmt, boolean delaying)
    {
        delayTime = delayAmt;
        if (delaying) delay();
    }
    public void act()
    {
        super.act();
        // check to start the delay
        if (Button.selected == getButtonNumber()) delay();
        // check to end the delay
        if (lastSelectTime > 0)
        {
            if (System.currentTimeMillis() - lastSelectTime > delayTime * 1000)
            {
                activate();
                lastSelectTime = 0;
            }
        }
    }
    public void delay()
    {
        deactivate();
        lastSelectTime = System.currentTimeMillis();
    }
}
