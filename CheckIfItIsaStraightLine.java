class Solution {

    public boolean checkStraightLine(int[][] coordinates) {

        int numberOfCoordinates = coordinates.length;
        if (numberOfCoordinates<3) {
            return true;
        }

        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];

        double slope = 0.0;
        double xIntercept = 0.0, yIntercept = 0.0;
        boolean isParellel = false, isPerpendicular = false;

        if (y1 == y2) {
            isParellel = true;
        } else if (x1 == x2) {
            isPerpendicular = true;
        } else {
            slope = (double)(y2 - y1) / (x2 - x1);
            xIntercept = x1 - (y1 / slope);
            yIntercept = y1 - (slope * x1);
        }

        for (int i = 2; i<numberOfCoordinates; i++) {

            int x = coordinates[i][0];
            int y = coordinates[i][1];
            
            if (isParellel && y != y1) {
                return false;
            } else if (isPerpendicular && x != x1) {
                return false;
            } else if (!isParellel && !isPerpendicular) {

                double new_slope = (double)(y - y1) / (x - x1);
                double new_xIntercept = x - (y / slope);
                double new_yIntercept = y - (slope * x);

                if (slope - new_slope > 0.000001 ||
                    new_xIntercept - xIntercept > 0.000001 ||
                    new_yIntercept - yIntercept > 0.000001) {
                    return false;
                }
            }
        }
        return true;
    }
}
