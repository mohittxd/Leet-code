class Solution {
    private double radius;
    private double xCenter;
    private double yCenter;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        double x, y;
        do {
            // Sample uniformly in the bounding square [-radius, radius] x [-radius, radius]
            x = -radius + Math.random() * 2 * radius;
            y = -radius + Math.random() * 2 * radius;
        } while (x * x + y * y > radius * radius); // reject points outside the circle

        return new double[]{xCenter + x, yCenter + y};
    }
}