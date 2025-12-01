package syn.getdata.data.domain.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import syn.getdata.data.domain.test.service.CalService

@RestController
class CalController(private val calService: CalService) {

    @GetMapping("/sum")
    fun sum(@RequestParam("a") a : String, @RequestParam("b") b : String) : String { //
        return calService.calcSum(a, b)
    }

    @GetMapping("/sub")
    fun sub(@RequestParam("a") a : String, @RequestParam("b") b : String) : String {
        return calService.calcSubstract(a, b)
    }

    @GetMapping("/mul")
    fun mul(@RequestParam a : String, @RequestParam("b") b : String) : String {
        return calService.calcMultiply(a, b)
    }

    @GetMapping("/div")
    fun div(@RequestParam("a") a : String, @RequestParam("b") b : String) : String {
        return calService.calcDivision(a, b)
    }

}