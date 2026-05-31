class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val map = mutableMapOf<Int, Int>()
        for(i in 0 until s.length) {
            val sCode = s[i].code
            val tCode = t[i].code
            if (map.containsKey(sCode)) {
                map[sCode] = map[sCode]!! + 1
            } else {
                map[sCode] = 1
            }
            if (map.containsKey(tCode)) {
                map[tCode] = map[tCode]!! - 1
            } else {
                map[tCode] = -1
            }
        }

        for (entry in map) {
            val (key, value) = entry
            if (value != 0) return false
        }

        return true
    }
}
