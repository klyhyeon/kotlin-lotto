package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CalculatorTest {


    @Test
    fun `empty or null returns zero`() {
        val zeroCal = Calculator("")
        val nullCal = Calculator(null)

        assertThat(zeroCal.calculate()).isEqualTo(0)
        assertThat(nullCal.calculate()).isEqualTo(0)
    }

    @Test
    fun `String format returns one`() {
        val strCal = Calculator("ㄴ123")

        assertThat(strCal.calculate()).isEqualTo(1)
    }

    @Test
    fun `, delimiter returns sum of two numbers`() {
        val strCal = Calculator("1,2")

        assertThat(strCal.calculate()).isEqualTo(3)
    }

    @Test
    fun `colon delimiter returns sum of two numbers`() {
        val strCal = Calculator("1,2")

        assertThat(strCal.calculate()).isEqualTo(3)
    }

    @Test
    fun `custom delimiter returns sum of all numbers`() {
        val reg = Regex("//(.)\n")

        val input = "//,\n"

        var i = 1
        reg.find(input)?.groupValues?.forEach { println("group ${i++} $it") }

        assertTrue(reg.matches(input))
    }

}