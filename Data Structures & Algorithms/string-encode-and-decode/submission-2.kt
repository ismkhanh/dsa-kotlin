class Solution {

    fun encode(strs: List<String>): String {
        val sb = StringBuilder()
        for(str in strs) {
            sb.append(str.length)
            sb.append('#')
            sb.append(str)
        }

        return sb.toString()
    }

    fun decode(str: String): List<String> {
        var sb = StringBuilder(str)
        val ans = mutableListOf<String>()
        
        while (sb.length > 0) {
            val (length, initialDrop) = getWordLengthAndStartIndex(sb.toString())
            var encoded = sb.toString()
            encoded = encoded.drop(initialDrop)
            val word = encoded.substring(0, length)
            ans.add(word)
            sb = sb.delete(0, initialDrop + length)
        }
        return ans
    }

    fun getWordLengthAndStartIndex(str: String): Pair<Int, Int> {
        val digitStr = StringBuilder()
        for (c in str) {
            if (c.isDigit()) digitStr.append(c)
            else break
        }
        val digit = digitStr.toString().toInt()

        return Pair(digit, digitStr.length+1)
    }

    
}
