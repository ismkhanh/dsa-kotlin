class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val cache = mutableMapOf<Pair<Int, Int>, Int>()
        return ways(0, 0, nums, target, cache)
    }

    fun ways(
        i: Int, 
        sum: Int, 
        nums: IntArray, 
        target: Int,
        cache: MutableMap<Pair<Int,Int>, Int>
    ): Int {
        if (i >= nums.size) {
            return if (sum == target) 1 else 0
        }
        val pair = Pair(i, sum)
        cache[pair]?.let {return it}
        var count = 0
        count += ways(i+1, sum + nums[i], nums, target, cache)
        count += ways(i+1, sum - nums[i], nums, target, cache)
        cache[pair] = count
        return count
    }
}
