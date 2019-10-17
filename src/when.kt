fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}

fun mix(color1: Color, color2: Color) =
    when(setOf(color1, color2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun mixOptimized(color1: Color, color2: Color) =
    when {
        (color1 == color2) -> color1
        (color1 == Color.RED && color2 == Color.YELLOW) ||
        (color1 == Color.YELLOW && color2 == Color.RED) ->
            Color.ORANGE
        (color1 == Color.YELLOW && color2 == Color.BLUE) ||
        (color1 == Color.BLUE && color2 == Color.YELLOW) ->
            Color.GREEN
        (color1 == Color.BLUE && color2 == Color.VIOLET) ||
        (color1 == Color.VIOLET && color2 == Color.BLUE) ->
            Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun main() {
    println(getMnemonic(Color.RED))
    println(getWarmth(Color.INDIGO))
    println(mix(Color.BLUE, Color.VIOLET))
    println(mixOptimized(Color.BLUE, Color.BLUE))
}