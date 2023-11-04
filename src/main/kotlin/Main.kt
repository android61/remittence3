const val ERROR_LIMIT = -1
const val ERROR_TYPE = -2

fun getComission (cardType: String = "Vk Pay", sumLastRemittence: Int = 0, remittence: Int = 5000): Int {
    return when (cardType) {
        "Maestro", "Mastercard" -> (if (sumLastRemittence + remittence <= 600000 && remittence <= 150_000)
            comissionMaestroMastercard(remittence)
        else ERROR_LIMIT)

        "Visa", "Мир" -> (if (sumLastRemittence + remittence <= 600000 && remittence <= 150_000)
            comissionVisaMir(remittence, minCommission)
        else ERROR_LIMIT)

        "Vk Pay" -> (if (sumLastRemittence + remittence <= 40000 && remittence <= 15_000) 0 else ERROR_LIMIT)
        else -> ERROR_TYPE

    }
}

val minCommission = 35
fun comissionVisaMir (remittence:Int, minCommission: Int) =
    if ((remittence * 0.0075) > minCommission)
        (remittence * 0.0075).toInt()
    else minCommission


fun comissionMaestroMastercard (remittence: Int) =
    if (remittence > 75000)
        (remittence * 0.006 + 20).toInt()
    else 0