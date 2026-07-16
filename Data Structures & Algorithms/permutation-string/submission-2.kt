class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val arr1 = IntArray(26)
        
        for(c in s1) {
            val index = c - 'a'
            arr1[index]++
        }

        val arr2 = IntArray(26)
        var l = 0
        var r = 0

        while (l <= r && r < s2.length) {
            val index = s2[r] - 'a'
            arr2[index]++
            if (windowLen(l, r) == s1.length) {
                if (arr1.contentEquals(arr2)) return true
                val lIndex = s2[l] - 'a'
                arr2[lIndex]--
                l++
            } 
            r++
        }

        return false
    }

    private fun windowLen(left: Int, right: Int) = right - left + 1
}
