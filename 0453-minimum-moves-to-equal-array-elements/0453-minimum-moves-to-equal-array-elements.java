class Solution {
    public int minMoves(int[] nums) {
       Arrays.sort(nums);
       long move = 0;
       int n = nums.length;
       for(int i=0;i<n;i++){
        move += nums[i] - nums[0];
       } 
       return (int)move;
    }
}