// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of
//  candidates where the chosen numbers sum to target. You may return the combinations in any order.
// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency 
// of at least one of the chosen numbers is different.
// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations 
// for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.
import java.util.*;

public class LC39 {
    public void solve(int[] candidates, int target, int index, ArrayList<Integer> temp,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }

        temp.add(candidates[index]);
        solve(candidates, target - candidates[index], index, temp, result);
        temp.remove(temp.size() - 1);

        solve(candidates, target, index + 1, temp, result);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(candidates, target, 0, temp, result);
        return result;
    }
}
