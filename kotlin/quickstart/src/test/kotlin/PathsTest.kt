import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathsTest {
    val a = Point(0, 10)
    val b = Point(0, 20)
    val c = Point(10, 20)
    val ab = Segment(a, b)
    val ac = Segment(a, c)
    val bc = Segment(b, c)

    @Test
    fun testSegmentDistance0() {
        val segment = Segment(a, a)
        assertEquals(0.0, segment.distance, 0.01)
    }

    @Test
    fun testSegmentDistanceNonZero() {
        assertEquals(10.0, ab.distance, 0.01)
    }
}
