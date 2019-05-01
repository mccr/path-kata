class PathList(private val paths: List<Path>) {
    fun shortestPath(): Path? {
        return shortestPathOf(paths)
    }

    private fun shortestPathOf(pathsToQuery : List<Path>) = pathsToQuery.minBy(Path::distance)

    fun shortestPathWithStops(stopList: List<Point>): Path? =
            shortestPathOf(filterByStops(stopList))

    fun filterByStops(stopList: List<Point>): List<Path> = paths.filter { it.stops().containsAll(stopList) }
}
