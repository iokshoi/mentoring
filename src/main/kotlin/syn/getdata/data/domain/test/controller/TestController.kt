package syn.getdata.data.domain.test.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import syn.getdata.data.domain.test.service.TestService

@RestController
class TestController(private val testService: TestService) {
    @GetMapping("/memo")
    fun memo(@RequestParam("id") id: Int): String {
        return testService.getMemo(id)
    }

    @GetMapping("/delete")
    fun delete(@RequestParam("id") id: Int): String {
        testService.deleteMemo(id)
        return "complete"
    }

    @GetMapping("/edit")
    fun edit(@RequestParam("memo") memo: String, @RequestParam("id") id: Int): String {
        testService.editMemo(id, memo)
        return "complete"
    }

    @GetMapping("/create")
    fun create(@RequestParam("memo") memo: String): String {
        testService.createMemo(memo)
        return "complete"
    }

    @GetMapping("/all")
    fun getAll() = testService.getAll()
}
