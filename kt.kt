fun boyerMoore(text: String, pattern: String): Int {
    val n = text.length
    val m = pattern.length
    val right = IntArray(256) { -1 }

    for (i in 0 until m) {
        right[pattern[i].toInt()] = i
    }

    var skip: Int
    for (i in 0 <= n - m) {
        skip = 0
        for (j in m - 1 downTo 0) {
            if (pattern[j] != text[i + j]) {
                skip = Math.max(1, j - right[text[i + j].toInt()])
                break
            }
        }
        if (skip == 0) return i
    }
    return -1
}
