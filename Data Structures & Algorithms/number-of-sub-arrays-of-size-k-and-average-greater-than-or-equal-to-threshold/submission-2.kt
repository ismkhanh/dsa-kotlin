class Solution {
    fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
        var ans = 0
        var cur = 0
        var left = 0
        var right = 0
        while(right < arr.size) {
            cur += arr[right]
            if (windowLength(left, right) == k) {
                if (isWithinThreshold(cur, k, threshold)) ans++
                cur -= arr[left++]
            }
            right++
        }

        return ans
    }

    private fun windowLength(
        left: Int,
        right: Int,
    ) = right - left + 1

    private fun isWithinThreshold(
        cur: Int, 
        k: Int, 
        threshold: Int
    ) = (cur / k) >= threshold
}
