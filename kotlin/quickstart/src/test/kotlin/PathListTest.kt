import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PathListTest {

    @Test
    fun `if list have 1 path, return it as shortest one`() {
        val path = Path(emptyList())
        val pathList = PathList(listOf(path))

        assertEquals(path, pathList.shortestPath())
    }

    @Test
    fun `if list have no paths, return null`() {
        val pathList = PathList(emptyList())

        assertEquals(null, pathList.shortestPath())
    }

    @Test
    fun `if list have 2 paths, return the one with shortest distance`() {
        val path1 = Path(listOf(Segment(Point(0, 0), Point(0, 2))))
        val path2 = Path(listOf(Segment(Point(0, 0), Point(0, 1))))
        val pathList = PathList(listOf(path1, path2))

        assertEquals(path2, pathList.shortestPath())
    }

    @Test
    fun `if list have 3 paths, return the one with shortest distance with given stops`() {
        val requiredStop = Point(0, 1)
        val path1 = Path(listOf(Segment(requiredStop, Point(0, 4))))
        val path2 = Path(listOf(Segment(requiredStop, Point(0, 5))))
        val path3= Path(listOf(Segment(Point(0, 0), Point(0, 2))))

        val pathList = PathList(listOf(path1, path2, path3))

        assertEquals(path1, pathList.shortestPathWithStops(listOf(requiredStop)))
    }

    @Test
    fun `if list have no path, filterByStops should return null`() {
        val pathList = PathList(emptyList())

        assertEquals(emptyList<Point>(), pathList.filterByStops(emptyList()))
    }

    @Nested
    @DisplayName("FilterByStops with 1 path")
    inner class FilterByStopsWithOnePath {

        @Test
        fun `should return empty list, if this path do not have required stops`() {
            val pathList = PathList(listOf(Path(emptyList())))

            assertEquals(emptyList<Path>(), pathList.filterByStops(emptyList()))
        }

        @Test
        fun `should return this path, if this path have required stops`() {
            val origin = Point(0, 0)
            val dest = Point(0, 2)
            val path1 = Path(listOf(Segment(origin, dest)))
            val pathList = PathList(listOf(path1))

            assertEquals(listOf(path1), pathList.filterByStops(listOf(origin, dest)))
        }

    }

    @Nested
        @DisplayName("FilterByStops with 2 paths")
        inner class FilterByStopsWithTwoPaths {

            @Test
            fun `should return only the one path, that have required stops`() {
                val origin = Point(0, 0)
                val dest = Point(0, 2)
                val path1 = Path(listOf(Segment(Point(99, 99), dest)))
                val path2 = Path(listOf(Segment(origin, dest)))
                val pathList = PathList(listOf(path1, path2))

                assertEquals(listOf(path2), pathList.filterByStops(listOf(origin, dest)))
            }

        }


}