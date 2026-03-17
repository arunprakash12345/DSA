
// Given a collection of candidate numbers (candidates) and a target number (target), 
// find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

import java.util.*;

public class LC40 {
    public static void findCombination(int index, int[] candidates, int target, List<List<Integer>> res,
            List<Integer> temp) {

        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (index == candidates.length || target < 0)
            return;

        temp.add(candidates[index]);
        findCombination(index + 1, candidates, target - candidates[index], res, temp);
        temp.remove(temp.size() - 1);

        int nextIndex = index + 1;
        while (nextIndex < candidates.length && candidates[index] == candidates[nextIndex])
            nextIndex++;

        findCombination(nextIndex, candidates, target, res, temp);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0, candidates, target, res, temp);
        return res;
    }
}
