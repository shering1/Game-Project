import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SampleTest {
    val testSample = Sample() //create an instance of Sample class to test member function on

    @Test //telling JUnit to run as a test case
    fun testSum() {
        val expected = 10
        assertEquals(expected, testSample.sum(4, 6)) //determining pass or fail of a test case
    }
}

//JUnit
//testing framework for the Java programming language
//test-driven development
//linked as a JAR at compile time

//the system will build->run tests-> run the main function