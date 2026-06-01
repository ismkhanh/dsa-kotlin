class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        var r = 0
        val seen = mutableMapOf<Char, Int>()
        var maxWindowLength = 0
        while (r < s.length) {
            val c = s[r]
            if (seen.containsKey(c) && seen[c]!! >= l) {
                l = seen[c]!! + 1
            }
            seen[c] = r
            maxWindowLength = maxOf(maxWindowLength, windowLength(l, r))
            r++
        }

        return maxWindowLength
    }

    private fun windowLength(left: Int, right: Int) = right - left + 1
}
