/**
 * Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
 */

class Solution {
    public int compareVersion(String version1, String version2) {
        // Invalid input
        if (version1 == null || version1.length() == 0 
        || version2 == null || version2.length() == 0) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int M = version1Array.length;
        int N = version2Array.length;
        int maxLength = Math.max(M, N);
        for (int index = 0; index < maxLength; index++) {
            if (index >= M) {
                if (Integer.valueOf(version2Array[index]) > 0) {
                    return -1;
                }
                else {
                    continue;
                }
            }
            if (index >= N) {
                if (Integer.valueOf(version1Array[index]) > 0) {
                    return 1;
                }
                else {
                    continue;
                }
            }
            int version1Num = Integer.valueOf(version1Array[index]);
            int version2Num = Integer.valueOf(version2Array[index]);
            if (version1Num > version2Num) {
                return 1;
            }
            else if (version1Num < version2Num) {
                return -1;
            }
        }
        return 0;
    }
}