import java.awt.Polygon;
/**
 * Car is a class that contains the shape and position of a given car
 *
 * @author (Nicholas Sullivan)
 * @version (March 2016)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private final int[] xPoints;
    private final int[] yPoints;
    private final int[] xActualPoints;
    private final int[] yActualPoints;
    private final int nPoints;
    private int xPos;
    private int yPos;
    private int xInc;
    private int yInc;
    private Polygon actPoly;
    /**
     * Constructor for objects of class Car
     */
    public Car(int[] xp, int[] yp, int np)
    {
        xPoints = xp;
        yPoints = yp;
        nPoints = np;
        xActualPoints = new int[np];
        yActualPoints = new int[np];
        for (int i = 0; i < nPoints; i++)
        {
            xActualPoints[i] = xPoints[i];
            yActualPoints[i] = yPoints[i];
        }
        xPos = 0;
        yPos = 0;
        actPoly = new Polygon(xActualPoints, yActualPoints, nPoints);
        xInc = 0;
        yInc = 0;
    }

    public void setStep(int x, int y)
    {
        xInc = x;
        yInc = y;
    }
    public void setPosition(int x, int y)
    {
        xPos = x;
        yPos = y;
        for (int i = 0; i < nPoints; i++)
        {
            xActualPoints[i] = xPoints[i]+xPos;
            yActualPoints[i] = yPoints[i]+yPos;
        }
        actPoly = new Polygon(xActualPoints, yActualPoints, nPoints);
    }
    public void step()
    {
        xPos += xInc;
        yPos += yInc;
        for (int i = 0; i < nPoints; i++)
        {
            xActualPoints[i] = xPoints[i]+xPos;
            yActualPoints[i] = yPoints[i]+yPos;
        }
        actPoly = new Polygon(xActualPoints, yActualPoints, nPoints);
    }
    public Polygon getPolygon()
    {
        return actPoly;
    }
}

