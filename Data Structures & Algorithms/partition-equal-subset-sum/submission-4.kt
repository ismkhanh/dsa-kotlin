class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val total = nums.sum()
        if (total % 2 != 0) return false
        val target = total / 2
        val cache = Array(nums.size) { IntArray(target + 1) {-1}}
        return isPossible(0, total/2, nums, cache)
    }

    private fun isPossible(
        index: Int,
        target: Int,
        nums: IntArray,
        cache: Array<IntArray>
    ): Boolean {
        if (index >= nums.size) return false
        if (target < 0) return false
        if (target == 0) return true
        if (cache[index][target] != -1) return cache[index][target] == 1
        val take = isPossible(index+1, target - nums[index], nums, cache)
        val dontTake = isPossible(index+1, target, nums, cache)
        val res = take || dontTake
        cache[index][target] = if (res) 1 else 0
        return res
    }
}
