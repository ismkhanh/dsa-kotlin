class Solution {

    private val phoneMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {

        if (digits.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        val current = StringBuilder()

        backtrack(0, digits, current, result)

        return result
    }

    private fun backtrack(
        index: Int,
        digits: String,
        current: StringBuilder,
        result: MutableList<String>
    ) {

        if (index == digits.length) {
            result.add(current.toString())
            return
        }

        val letters = phoneMap[digits[index]]!!

        for (ch in letters) {
            current.append(ch)

            backtrack(index + 1, digits, current, result)

            current.deleteCharAt(current.length - 1) // backtrack
        }
    }
}