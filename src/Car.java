import java.awt.Polygon;
import java.awt.Point;
/**
 * Car is a class that contains the shape and position of a given car
 *
 * @author (Nicholas Sullivan)
 * @version (March 2016)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private int[] xPoints, yPoints;
    private int[] actxPoints, actyPoints;
    private int nPoints, xPos, yPos, xInc, yInc;
    private Point dest;
    private Polygon poly, actPoly;
    /**
     * Constructor for objects of class Car
     */
    public Car(int[] xp, int[] yp, int np)
    {
        poly = new Polygon(xp, yp, np);
        xPoints = xp;
        yPoints = yp;
        nPoints = np;
        actxPoints = new int[np];
        actyPoints = new int[np];
        for (int i = 0; i < nPoints; i++)
        {
            actxPoints[i] = xPoints[i];
            actyPoints[i] = yPoints[i];
        }
        xPos = 0;
        yPos = 0;
        actPoly = new Polygon(actxPoints, actyPoints, nPoints);
        xInc = 0;
        yInc = 0;
        dest = null;
    }
    public void setDestination(Point d)
    {
        dest = d;
    }
    public int getx()
    {
        return xPos;
    }
    public int gety()
    {
        return yPos;
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
            actxPoints[i] = xPoints[i]+xPos;
            actyPoints[i] = yPoints[i]+yPos;
        }
        actPoly = new Polygon(actxPoints, actyPoints, nPoints);
    }
    public void step()
    {
        xPos += xInc;
        yPos += yInc;
        for (int i = 0; i < nPoints; i++)
        {
            actxPoints[i] = xPoints[i]+xPos;
            actyPoints[i] = yPoints[i]+yPos;
        }
        actPoly = new Polygon(actxPoints, actyPoints, nPoints);
    }
    public Polygon getPolygon()
    {
        return actPoly;
    }
}

