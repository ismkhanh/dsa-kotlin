class Solution {
    private val result = mutableSetOf<List<Int>>()
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        combination(0, target, mutableListOf<Int>(), nums)
        return result.toList()
    }

    private fun combination(
        index: Int,
        target: Int,
        cur: MutableList<Int>,
        nums: IntArray,
    ) {
        val sum = cur.sum()
        if (sum == target) result.add(cur.toList())
        if (index == nums.size || sum > target) {
            return
        }

        cur.add(nums[index])
        combination(index, target, cur, nums)

        cur.removeAt(cur.size-1)
        combination(index+1, target, cur, nums)
    }
}
