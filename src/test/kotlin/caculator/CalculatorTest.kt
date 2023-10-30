package caculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

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
        val cal = Calculator("//l\n1l2l3");

        assertThat(cal.calculate()).isEqualTo(6)
    }

    @Test
    fun `if element less than zero, throw RuntimeException`() {
        val cal = Calculator("//l\n-1l2l3");

        assertThrows<RuntimeException> { cal.calculate() }
    }

}