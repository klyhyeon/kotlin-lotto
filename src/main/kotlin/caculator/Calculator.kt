package caculator

import java.lang.NumberFormatException

class Calculator(val input: String?) {

    fun calculate(): Int {
        val answer: Int
        if (input.isNullOrEmpty()) return 0
        try {
            answer = if (input.contains(",")) {
                splitComma().sum()
            } else {
                splitComma().sum()
            }
        } catch (e: NumberFormatException) {
            return 1
        }
        return answer
    }

    private fun splitComma() =
        input?.split(",")?.map { it.toInt() }.orEmpty()

    private fun splitColon() =
        input?.split(":")?.map { it.toInt() }.orEmpty()
}