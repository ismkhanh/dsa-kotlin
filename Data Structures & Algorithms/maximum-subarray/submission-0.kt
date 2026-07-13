class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var cur = 0
        var max = Int.MIN_VALUE
        for(i in 0 until nums.size) {
            cur += nums[i]
            max = maxOf(cur, max)
            if (cur < 0) cur = 0
        }
        return max
    }
}
