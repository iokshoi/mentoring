package syn.getdata.data.domain.test.service

import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class CalService {

    fun calcSum(a : String, b : String) : String {
        val result = BigDecimal(a).add(BigDecimal(b)) // 값의 연산을 자동으로 정밀하게 하게 해줌.
        return "$a + $b = ${result}"
    }

    fun calcSubstract(a : String, b : String) : String {
        val result = BigDecimal(a).subtract(BigDecimal(b))
        return "$a - $b = ${result}"
    }

    fun calcMultiply(a : String, b : String) : String {
        val result = BigDecimal(a).multiply(BigDecimal(b))
        return "$a * $b = ${result}"
    }

    fun calcDivision(a : String, b : String) : String {
        if(b == "0") {
            return "0으로 나눌 수 없습니다."
        }
        val result = BigDecimal(a).divide(BigDecimal(b))
        return "$a / $b = ${result}"
    }

}