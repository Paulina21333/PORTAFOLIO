package tools;

public class area {
    private double XMIN = 0.0;
    private double XMAX = 10.0;
    private double YMIN = 0.0;
    private double YMAX = 10.0;
    private int WIDTH = 300;
    private int HEIGHT = 300;

    public area() {
    }

    public area(double xMin, double xMax, double yMin, double yMax,
                          int width, int height) {
        XMIN = xMin;
        XMAX = xMax;
        YMIN = yMin;
        YMAX = yMax;
        WIDTH = width;
        HEIGHT = height;
    }

    public double calculateArea(double[] x, double[] y) {
        double area = 0.0;
        int n = Math.min(x.length, y.length);

        for (int i = 1; i < n; i++) {
            double base = Math.abs(x[i] - x[i - 1]);
            double height = (y[i] + y[i - 1]) / 2.0;
            area += base * height;
        }

        return area;
    }

    public int toScreenX(double x) {
        return (int) ((x - XMIN) * WIDTH / (XMAX - XMIN));
    }

    public int toScreenY(double y) {
        return (int) ((YMAX - y) * HEIGHT / (YMAX - YMIN));
    }

    public double getXMIN() {
        return XMIN;
    }

    public void setXMIN(double XMIN) {
        this.XMIN = XMIN;
    }

    public double getXMAX() {
        return XMAX;
    }

    public void setXMAX(double XMAX) {
        this.XMAX = XMAX;
    }

    public double getYMIN() {
        return YMIN;
    }

    public void setYMIN(double YMIN) {
        this.YMIN = YMIN;
    }

    public double getYMAX() {
        return YMAX;
    }

    public void setYMAX(double YMAX) {
        this.YMAX = YMAX;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }
}