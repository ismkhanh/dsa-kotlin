class Solution {
    private val result = mutableListOf<List<Int>>()
    fun subsets(nums: IntArray): List<List<Int>>  {
        generateSubsets(0, mutableListOf<Int>(), nums)
        return result
    }

    private fun generateSubsets(
        index: Int, 
        cur: MutableList<Int>,
        nums: IntArray
    ) {
        if (index == nums.size) {
            result.add(cur.toList())
            return
        }

        cur.add(nums[index])
        generateSubsets(index+1, cur, nums)

        cur.removeAt(cur.size-1)
        generateSubsets(index+1, cur, nums)
    }
}
