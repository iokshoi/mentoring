package syn.getdata.data.domain.test.service

import org.springframework.stereotype.Service
import syn.getdata.data.domain.test.repository.TestRepository

@Service
class TestService(private val testRepository: TestRepository) {
    fun getAll() = testRepository.getAll()

    fun getMemo(id: Int): String {
        return testRepository.get(id)
    }

    fun deleteMemo(id: Int) {
        testRepository.remove(id)
    }

    fun editMemo(id: Int, memo: String) {
        testRepository.set(id, memo)
    }

    fun createMemo(memo: String) {
        testRepository.add(memo)
    }
}
