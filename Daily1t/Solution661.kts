package Daily1t

fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
    val rows = img.size
    val cols = img[0].size
    val smoothedImg = Array(rows) { IntArray(cols) }

    for (j in 0..rows-1) {
        for (i in 0..cols-1) {
            var sum = 0
            var count = 0
            for (k in -1..1) {
                for (l in -1..1) {
                    val x = j + k
                    val y = i + l

                    if (x in 0..rows-1 && y in 0..cols-1) {
                        sum += img[x][y]
                        count++
                    }
                }
            }

            smoothedImg[j][i] = (sum/count)
        }
    }

    return smoothedImg
}