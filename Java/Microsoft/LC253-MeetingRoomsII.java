/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int meetingNumber = intervals.length;
        int[] startTimes = new int[meetingNumber];
        int[] endTimes = new int[meetingNumber];
        int minRooms = 0;
        // Store start time and end time into 2 seperate arrays
        for (int index = 0; index < meetingNumber; index++) {
            startTimes[index] = intervals[index].start;
            endTimes[index] = intervals[index].end;
        }
        // Sort the 2 arrays
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int endIndex = 0;
        for (int startIndex = 0; startIndex < meetingNumber; startIndex++) {
            // Found an overlap
            if (startTimes[startIndex] < endTimes[endIndex]) {
                minRooms++;
            // Current meeting starts after last meeting
            // No need to check endIndex out-of-bound since it goes slower than startIndex.
            } else {
                endIndex++;
            }
        }
        return minRooms;
    }
}