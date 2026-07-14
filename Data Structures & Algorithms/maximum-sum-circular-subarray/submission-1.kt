class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var curMax = 0
        var curMin = 0
        var globalMax = nums[0]
        var globalMin = nums[0]
        var total = 0
        for(num in nums) {
            curMax = maxOf(curMax + num, num)
            curMin = minOf(curMin + num, num)
            globalMax = maxOf(globalMax, curMax)
            globalMin = minOf(globalMin, curMin)
            total += num
        }
        return if (globalMax < 0) globalMax else maxOf(total - globalMin, globalMax)
    }
}
