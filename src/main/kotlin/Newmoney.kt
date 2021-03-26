import kotlin.math.ceil

fun main() {
    val cardType = "Mastercard"
    val amountOfPreviousTransfers = 100_00
    val amount = 246_000_00
    println(calculationOfCommission(amountOfPreviousTransfers, amount, cardType))
}

fun calculationOfCommission (amountOfPreviousTransfers: Int, amount: Int, cardType:String = "VK Pay" ): Int{
    val commission = when (cardType){
        "VK Pay" -> 0
        "Visa", "Мир" -> commissionForVisaAndMir(amount)
        else -> commissionForMastercardAndMaestro(amountOfPreviousTransfers, amount)
    }
    return commission
}

fun commissionForVisaAndMir (amount: Int): Int {
    val commissionPercent = 0.0075
    val commission = if (ceil(commissionPercent * amount.toDouble()) < 3500) 3500 else ceil(commissionPercent * amount.toDouble())
    return commission.toInt()
}

fun commissionForMastercardAndMaestro (amountOfPreviousTransfers: Int, amount: Int): Int {
    val commissionPercent = 0.006
    val commission = if (amountOfPreviousTransfers + amount < 75_000_00) 0 else (ceil(commissionPercent * amount.toDouble()) + 20_00)
    return commission.toInt()
}