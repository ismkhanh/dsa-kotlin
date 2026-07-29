class Solution {
    fun minWindow(s: String, t: String): String {
        val need = HashMap<Char, Int>()
        for(c in t) need[c] = need.getOrDefault(c, 0) + 1

        var have = 0
        var left = 0
        var minLen = s.length + 1
        var ansStartIdx = 0

        for(right in s.indices) {
            val c = s[right]
            if(need.containsKey(c)) {
                need[c] = need[c]!! - 1
                if (need[c] == 0) have++
            }

            while(have == need.size) {
                val newLen = right - left + 1
                if (newLen < minLen) {
                    minLen = newLen
                    ansStartIdx = left
                }
                var leftChar = s[left]
                if (need.containsKey(leftChar)) {
                    if (need[leftChar] == 0) have--
                    need[leftChar] = need[leftChar]!! + 1
                }
                left++
            }
        }

        return if (minLen > s.length) "" else s.substring(ansStartIdx, ansStartIdx + minLen)
    }
}
