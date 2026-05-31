class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            set.add(num)
        }
        var ans = 0
        for (num in set) {
            if (num-1 !in set) {
                var curValue = num+1
                var curAns = 1
                while (curValue in set) {
                    curAns++
                    curValue++
                }
                ans = maxOf(ans, curAns)
            }
        }
        return ans
    }
}
