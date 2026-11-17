class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    void solve(int index, int[] nums,
               List<Integer> current,
               List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(nums[index]);
        solve(index + 1, nums, current, ans);

        // Backtrack: remove the current element
        current.remove(current.size() - 1);

        // Exclude the current element
        solve(index + 1, nums, current, ans);
    }
}