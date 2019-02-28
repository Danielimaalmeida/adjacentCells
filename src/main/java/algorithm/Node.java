package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Point> points;

    public Node() {
        points = new ArrayList<>();

    }

    public List<Point> getPoints() {
        return this.points;
    }

    public void addPointToNode(Point point) {

            if(!this.getPoints().contains(point)) {
                this.getPoints().add(point);
            }
        }

}
