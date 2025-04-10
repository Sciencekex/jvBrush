fun isElementUnique(array: IntArray): Boolean {
    val set = HashSet<Int>()
    for (num in array) {
        if (set.contains(num)) return false
        set.add(num)
    }
    return true
}

fun minimumOperations(nums: IntArray): Int {
    var count = 0
    var currentArray = nums
    if (isElementUnique(currentArray)) return count

    while (currentArray.size>=3) {
        currentArray = currentArray.copyOfRange(3, currentArray.size)
        count+=1
        if (isElementUnique(currentArray)) return count
    }

    return count+1
}