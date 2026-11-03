class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            moves += nums[n-1]-nums[i];
        }
        return moves;
    }
}