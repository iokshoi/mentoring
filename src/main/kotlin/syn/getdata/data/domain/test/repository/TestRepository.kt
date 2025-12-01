package syn.getdata.data.domain.test.repository

import org.springframework.stereotype.Component

@Component
class TestRepository {
    private var memo = ArrayList<String>()

    fun get(id: Int) = memo[id]

    fun add(memo: String) = this.memo.add(memo)

    fun set(id: Int, memo: String) {
        this.memo[id] = memo
    }

    fun remove(id: Int) = this.memo.removeAt(id)

    fun getAll() = memo
}