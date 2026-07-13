class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        var i = 0
        var j = 0
        val map = mutableMapOf<Int, Int>()
        while (j < nums.size) {
            if (map.values.contains(nums[j])) return true
            map[j] = nums[j]
            if (windowLength(i, j) == k) {
                map.remove(i)
                i++
            }
            j++
        }
        return false
    }

    private fun windowLength(left: Int, right: Int) = right - left

}
