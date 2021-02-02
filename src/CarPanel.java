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
    private final Car[][] carsRight = new Car[X][Y];
    private final Car[][] carsDown = new Car[X][Y];
    private final Car[][] carsLeft = new Car[X][Y];
    private final Car[][] carsUp = new Car[X][Y];
    public static final Dimension SCREEN = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int HEIGHT = (int) SCREEN.getHeight();
    private final int SIZE = HEIGHT/20;

    public CarPanel()
    {
        setBackground(Color.white);
        setPreferredSize(new Dimension(10*SIZE, 10*SIZE));
        for (int i  = 0; i < X; i++)
        {
            for (int j  = 0; j < Y; j++)
            {
                int[] x = {0, SIZE / 2, SIZE, SIZE / 2};
                int[] y = {SIZE / 2, 0, SIZE / 2, SIZE};
                carsRight[i][j] = new Car(x, y, 4);
                carsDown[i][j] = new Car(x, y, 4);
                carsLeft[i][j] = new Car(x, y, 4);
                carsUp[i][j] = new Car(x, y, 4);
                int n = SIZE * 7;
                int xPos = 0;
                int yPos = 0;
                int space = SIZE * 2;
                carsRight[i][j].setPosition(xPos + space * j - n, yPos + space * i + SIZE);
                carsRight[i][j].setStep(1, 0);
                carsDown[i][j].setPosition(xPos + space * i + SIZE*2, yPos + space * j - n);
                carsDown[i][j].setStep(0, 1);
                carsLeft[i][j].setPosition(xPos + SIZE*9 - space * j + n, yPos + space * i + SIZE*2);
                carsLeft[i][j].setStep(-1, 0);
                carsUp[i][j].setPosition(xPos + space * i + SIZE, yPos + SIZE*9 - space * j + n);
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
