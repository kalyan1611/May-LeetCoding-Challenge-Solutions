class Solution {

    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue <DistancePointPair> distancePriorityQueue = new PriorityQueue <> ();

        for (int i = 0; i < points.length; i++) {
            DistancePointPair distancePointPair = new DistancePointPair(points[i][0], points[i][1]);
            distancePriorityQueue.add(distancePointPair);
            if (distancePriorityQueue.size() > K) {
                distancePriorityQueue.poll();
            }
        }

        int[][] nearestPoints = new int[K][2];

        for (int i = 0; i < K; i++) {
            DistancePointPair distancePointPair = distancePriorityQueue.poll();
            nearestPoints[i][0] = distancePointPair.x;
            nearestPoints[i][1] = distancePointPair.y;
        }

        return nearestPoints;
    }
}

class DistancePointPair implements Comparable <DistancePointPair> {

    public int x;
    public int y;
    private int distance;

    DistancePointPair(int x, int y) {
        this.x = x;
        this.y = y;
        this.distance = (int)(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public int compareTo(DistancePointPair other) {
        return -1 * Integer.compare(this.distance, other.distance);
    }
}
