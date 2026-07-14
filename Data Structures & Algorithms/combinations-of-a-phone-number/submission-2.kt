class Solution {
    private val result = mutableListOf<String>()
    private val map = buildDigitMap()

    fun letterCombinations(digits: String): List<String> {
        generateSubstrings(StringBuilder(), digits)
        return result
    }

    private fun generateSubstrings(cur: StringBuilder, digits: String) {
        if (cur.length == digits.length) {
            if (cur.length > 0) result.add(cur.toString())
            return
        }
        val index = cur.length
        val digit = digits[index].digitToInt()

        for(char in map[digit]!!) {
            cur.append(char)
            generateSubstrings(cur, digits)
            cur.deleteCharAt(cur.length-1)
        }
    }

    private fun buildDigitMap(): Map<Int, CharArray> {
       return mapOf(
            2 to charArrayOf('a', 'b', 'c'),
            3 to charArrayOf('d', 'e', 'f'),
            4 to charArrayOf('g', 'h', 'i'),
            5 to charArrayOf('j', 'k', 'l'),
            6 to charArrayOf('m', 'n', 'o'),
            7 to charArrayOf('p', 'q', 'r', 's'),
            8 to charArrayOf('t', 'u', 'v'),
            9 to charArrayOf('w', 'x', 'y', 'z')
       )
    }
}
