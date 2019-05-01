import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathTest {

    @Test
    fun `if path have 1 segment, the distance of a path is equals the segment distance`() {
        val segment = Segment(Point(0, 1), Point(2, 3))
        val segments = listOf(segment)
        val path = Path(segments)

        assertEquals(segment.distance, path.distance())
    }

    @Test
    fun `if path have 2 segments, the distance of a path is equals to the sum of the segments distances`() {
        val segment = Segment(Point(0, 1), Point(2, 3))
        val segment2 = Segment(Point(0, 3), Point(1, 3))
        val segments = listOf(segment, segment2)
        val path = Path(segments)

        assertEquals(segment.distance + segment2.distance, path.distance())
    }

    @Test
    fun `if path have one segment, the list of stops are origin and destination of this segment`() {
        val origin = Point(0, 1)
        val dest = Point(2, 3)
        val segment = Segment(origin, dest)
        val path = Path(listOf(segment))

        assertEquals(listOf(origin, dest), path.stops())
    }

    @Test
    fun `if path have 2 segments, the list of stops are origin and destination of first segment and destination of the second segment`() {
        val origin = Point(0, 1)
        val dest = Point(2, 3)
        val segment = Segment(origin, dest)

        val dest2 = Point(2, 4)
        val segment2 = Segment(dest, dest2)

        val path = Path(listOf(segment, segment2))

        assertEquals(listOf(origin, dest, dest2), path.stops())
    }
}