class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>(), ans);

        return ans;
    }

    void solve(int start, int[] nums,
               List<Integer> current,
               List<List<Integer>> ans) {

        // Store every subset
        ans.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            solve(i + 1, nums, current, ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}