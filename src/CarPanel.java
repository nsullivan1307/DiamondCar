import javax.swing.JPanel;
import java.awt.*;
/**
 * CarPanel extends JPanel, shows animation of diamond cars in intersection.
 *
 * @author (Nicholas Sullivan)
 * @version (March 2016, updated Feb 2021)
 */
public class CarPanel extends JPanel
{
    public final int X = 4, Y = 15;
    private Car[][] carsRight = new Car[X][Y];
    private Car[][] carsDown = new Car[X][Y];
    private Car[][] carsLeft = new Car[X][Y];
    private Car[][] carsUp = new Car[X][Y];
    public static final Dimension SCREENSIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) SCREENSIZE.getWidth(), HEIGHT = (int) SCREENSIZE.getHeight();
    private int SIZE = HEIGHT/20;
    private int[] x = {0, SIZE/2, SIZE, SIZE/2};
    private int[] y = {SIZE/2, 0, SIZE/2, SIZE};
    private int n = SIZE*7;
    private int xPos = 0*SIZE;
    private int yPos = 0*SIZE;
    private int space = SIZE*2;
    public CarPanel()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(10*SIZE, 10*SIZE));
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                carsRight[i][j] = new Car(x, y, 4);
                carsDown[i][j] = new Car(x, y, 4);
                carsLeft[i][j] = new Car(x, y, 4);
                carsUp[i][j] = new Car(x, y, 4);
                carsRight[i][j].setPosition(xPos+space*j-n, yPos+space*i+SIZE*1);
                carsRight[i][j].setStep(1, 0);
                carsDown[i][j].setPosition(xPos+space*i+SIZE*2, yPos+SIZE*0+space*j-n);
                carsDown[i][j].setStep(0, 1);
                carsLeft[i][j].setPosition(xPos+SIZE*9-space*j+n, yPos+space*i+SIZE*2);
                carsLeft[i][j].setStep(-1, 0);
                carsUp[i][j].setPosition(xPos+space*i+SIZE*1, yPos+SIZE*9-space*j+n);
                carsUp[i][j].setStep(0, -1);
            }
        }
    }
    public void start()
    {
        for (int i = 0; i < SIZE*16; i++)
        {
            for (int j = 0; j < X; j++)
            {
                for (int k = 0; k < Y; k++)
                {
                    carsRight[j][k].step();
                    carsDown[j][k].step();
                    carsLeft[j][k].step();
                    carsUp[j][k].step();
                }
            }
            repaint();
            try
            {
                Thread.sleep(15);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        page.setColor(Color.BLUE);
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                page.fillPolygon(carsRight[i][j].getPolygon());
            }
        }
        page.setColor(Color.RED);
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                page.fillPolygon(carsDown[i][j].getPolygon());
            }
        }
        page.setColor(Color.GREEN);
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                page.fillPolygon(carsLeft[i][j].getPolygon());
            }
        }
        page.setColor(Color.ORANGE);
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                page.fillPolygon(carsUp[i][j].getPolygon());
            }
        }
    }
}
