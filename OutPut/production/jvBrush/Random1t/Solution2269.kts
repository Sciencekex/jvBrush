fun divisorSubstrings(num: Int, k: Int): Int {
    val str = num.toString()
    val subStrings = mutableListOf<String>()

    for (i in 0..str.length - k) {
        val substring = str.substring(i, i + k)
        subStrings.add(substring)
    }

    var result = 0
    for (s in subStrings) {
        if (s.toInt() != 0 && num % s.toInt() == 0) result += 1
    }
    return result
}

println(divisorSubstrings(240, 2))