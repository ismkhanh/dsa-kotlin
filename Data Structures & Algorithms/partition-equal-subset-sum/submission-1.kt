class Solution {
    var totalSum = 0
    fun canPartition(nums: IntArray): Boolean {
        if (nums.size <= 1) return false
        totalSum = nums.sum()
        val cache = mutableMapOf<Pair<Int, Int>, Boolean>()
        return canPartitionHelper(0, 0, nums, cache)
    }

    fun canPartitionHelper(
        i: Int, 
        curSum: Int, 
        nums: IntArray, 
        cache: MutableMap<Pair<Int, Int>, Boolean>
    ): Boolean {
        if (i >= nums.size) return false
        val pair = Pair(i, curSum)
        if (cache.containsKey(pair)) return cache[pair]!!
        
        val res = if (canPartitionHelper(i+1, curSum, nums,cache)) true
        else {
            val newCurSum = curSum + nums[i]
            if (newCurSum == (totalSum - newCurSum)) return true
            canPartitionHelper(i+1, newCurSum, nums, cache)
        }
        cache[pair] = res
        return res
    }
}
