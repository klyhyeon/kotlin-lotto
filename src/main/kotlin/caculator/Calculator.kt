package caculator

import java.lang.NumberFormatException

val REGEX = Regex("//(.)\n")

class Calculator(val input: String?) {

    fun calculate(): Int {
        val answer: Int
        if (input.isNullOrEmpty()) return 0
        try {
            answer = if (REGEX.containsMatchIn(input)) {
                splitByDelimiter(delimiter = REGEX.find(input)!!.groupValues[1], isCustomDelimiter = true)
            } else if (input.contains(",")) {
                splitByDelimiter(",")
            } else {
                splitByDelimiter(":")
            }
        } catch (e: NumberFormatException) {
            return 1
        }
        return answer
    }

    private fun splitByDelimiter(
        delimiter: String,
        isCustomDelimiter: Boolean = false,
    ): Int {
        if (isCustomDelimiter) {
            return input!!.substring(input.indexOf("\n").plus(1)).split(delimiter).sumOf { it.toInt() }
        }
        return input?.split(delimiter)?.map { it.toInt() }.orEmpty().sum()
    }
}