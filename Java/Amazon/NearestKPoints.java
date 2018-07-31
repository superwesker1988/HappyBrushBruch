import java.util.List;
import java.util.PriorityQueue;

public class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    private int getDistance(Point point) {
        if (point == null) {
            return Integer.MAX_VALUE;
        }
        return (int) (Math.pow(point.x, 2) + Math.pow(point.y, 2)) / 2;
    }

    public List<Point> NearestKPoints(List<Point> points, int k) {
        List<Point> answer = new ArrayList<Point>();
        if (points == null || k == 0) {
            return asnwer;
        }
        if (points.size() <= k) {
            return points;
        }
        Comparator<Point> comparator = new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                int p1D = getDistance(p1);
                int p2D = getDistance(p2);
                if (p1D != p2D) {
                    return p1D - p2D;
                } else if (p1.x != p2.x) {
                    return p1.x - p2.x;
                } else {
                    return p1.y - p2.y;
                }
            }
        };
        PriorityQueue<Point> priorityQueue = new PriorityQueue<Point>(k, comparator);

        for (Point point : points) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(point);
            }
            else {
                Point topOfPoint = priorityQueue.peek();
                if (comparator.compare(topOfPoint, point) > 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(point);
                }
            }
        }
        while (priorityQueue.size() > 0) {
            answer.add(priorityQueue.poll());
        }
        Collection.reverse(answer);
        return answer;
    }
}