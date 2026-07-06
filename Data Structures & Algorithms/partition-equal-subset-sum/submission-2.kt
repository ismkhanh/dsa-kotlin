class Solution {
    fun canPartition(nums: IntArray): Boolean {
        if (nums.size <= 1) return false
        
        val totalSum = nums.sum()
        if (totalSum % 2 != 0) return false
        val cache = mutableMapOf<Pair<Int, Int>, Boolean>()
        return canPartitionHelper(0, totalSum/2, nums, cache)
    }

    fun canPartitionHelper(
        i: Int, 
        target: Int, 
        nums: IntArray, 
        cache: MutableMap<Pair<Int, Int>, Boolean>
    ): Boolean {
        if (i >= nums.size) return false
        val pair = Pair(i, target)
        if (cache.containsKey(pair)) return cache[pair]!!
        
        val res = if (canPartitionHelper(i+1, target, nums,cache)) true
        else {
            val newTarget = target - nums[i]
            if (newTarget == 0) return true
            canPartitionHelper(i+1, newTarget, nums, cache)
        }
        cache[pair] = res
        return res
    }
}
