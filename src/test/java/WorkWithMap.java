import org.junit.jupiter.api.Test;
import org.openqa.selenium.json.JsonOutput;

import java.awt.geom.Point2D;

public class WorkWithMap {

    @Test
    public void distanceBetweenTwoPoints() {
        double x1 = 1;
        double y1 = 2;
        double x2 = 3;
        double y2 = 4;

        double distance = getDistance(x1, x2, y1, y2);
        System.out.println("Расстояние между двумя точками - " + distance + ".");

            }
    private double getDistance(double x1, double x2, double y1, double y2) {
        return Point2D.distance(x1,y1,x2,y2);
    }
}
