import javax.swing.*;
/**
 * Driver class containing main() function.
 *
 * @author (Nicholas Sullivan)
 * @version (March 2016)
 */
public class DiamondCarDriver
{
    public static void main(String[] args)
    {
        JFrame tf1 = new JFrame("Diamond Car");
        CarPanel tp1 = new CarPanel();
        tf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tf1.getContentPane().add(tp1);
        tf1.pack();
        tf1.setVisible(true);
        tp1.start();

    }
}
