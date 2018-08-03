/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return answer;
        }
        boolean[] isPicked = new boolean[nums.length];
        Arrays.sort(nums);
        populateAnswerByDFS(nums, new boolean[nums.length], answer, new ArrayList<Integer>());
        return answer;
    }

    private void populateAnswerByDFS(int[] nums, boolean[] isPicked, List<List<Integer>> answer, List<Integer> curCombo) {
        if (curCombo.size() == nums.length) {
            answer.add(new ArrayList<Integer>(curCombo));
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (isPicked[index]) {
                index++;
                continue;
            }
            isPicked[index] = true;
            curCombo.add(nums[index]);
            populateAnswerByDFS(nums, isPicked, answer, curCombo);
            curCombo.remove(curCombo.size() - 1);
            isPicked[index] = false;
            index++;
            while (index < nums.length && nums[index] == nums[index - 1]) {
                index++;
            }
        }
    }
}