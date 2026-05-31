class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val charCount = IntArray(26) {0}
        val n = s.length
        for (i in 0 until n) {
            val sIndex = s[i].code - 'a'.code
            val tIndex = t[i].code - 'a'.code
            charCount[sIndex]++
            charCount[tIndex]--
        }

        charCount.forEach {
            if (it != 0) return false
        }

        return true
    }
}
