package algorithm;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {

        if(o == null)
            return false;

        Point toCompare = (Point) o;

        return this.getY() == toCompare.getY() && this.getX() == toCompare.getX();

    }


}
