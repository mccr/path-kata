class Path(private val segments: List<Segment>) {
    fun distance(): Double {
        return segments.sumByDouble(Segment::distance)
    }

    fun stops(): List<Point> =
            segments.fold(mutableListOf(segments.first().origin),
                    { stops, segment ->
                        stops.add(segment.dest)
                        stops
                    })
}
