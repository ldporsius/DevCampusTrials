package nl.codingwithlinda.testversionscatalog

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Junit5Test {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `test`(value: Int) {

        assert(value in 1..3)
    }
}