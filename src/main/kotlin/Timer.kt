fun main() {
    val time = 59
    println(agoToText(time))
}

fun agoToText (time: Int): String {
    val textAgo = when (time) {
        in 0..60 -> "только что"
        in 61..60*60 -> minuteCases(time)
        in 60*60+1..24*60*60 -> hoursCases(time)
        in 24*60*60+1..2*24*60*60 -> "сегодня"
        in 2*24*60*60+1..3*24*60*60 -> "вчера"
        else -> "давно"
    }
    return textAgo
}
fun minuteCases (time: Int): String{
    val text = if (time/60 in 11..19) {
        "минут"
    } else when (time/60 % 10) {
        1 -> "минуту"
        in 2..4 -> "минуты"
        else -> "минут"
    }
    return "${time/60} $text назад"
}

fun hoursCases (time: Int): String {
    val text = if (time/3600 in 11..19) {
        "часов"
    } else when (time/3600 % 10) {
        1 -> "час"
        in 2..4 -> "часа"
        else -> "часов"
    }
    return "${time/3600} $text назад"
}