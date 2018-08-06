import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        Queue<Integer> courseQueue = new LinkedList<Integer>();
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            if (edges.size() < prerequisite[1] + 1) {
                edges.add(new ArrayList<Integer>());
            }
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int index = 0; index < indegrees.length; index++) {
            if (indegrees[index] == 0) {
                courseQueue.add(index);
            }
        }
        int courseCnt = 0;
        while (!courseQueue.isEmpty()) {
            int courseNum = courseQueue.poll();
            courseCnt++;
            for (int targetCourse : edges.get(courseNum)) {
                indegrees[targetCourse]--;
                if (indegrees[targetCourse] == 0) {
                    courseQueue.offer(targetCourse);
                }
            }
        }
        return courseCnt == numCourses;
    }
}