import org.junit.Test
import kotlin.test.assertEquals

class Comissiontest {

    @Test
    fun getComissionVkPayBranchIf() {

        val cardType = "Vk Pay"
        val sumLastRemittence = 0
        val remittence = 5000
        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(35, result)
    }


    @Test
    fun getComissionVkPayDailyBranchElse() {

        val cardType = "Vk Pay"
        val sumLastRemittence = 0
        val remittence = 46000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionVkPayMonthBranchElse() {

        val cardType = "Vk Pay"
        val sumLastRemittence = 50000
        val remittence = 10000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }


    @Test
    fun getComissionVisaBranchIf() {

        val cardType = "Visa"
        val sumLastRemittence = 0
        val remittence = 5000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(37, result)
    }

    @Test
    fun getComissionMirUsualBranchIf() {

        val cardType = "Мир"
        val sumLastRemittence = 0
        val remittence = 5000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(37, result)
    }

    @Test
    fun getComissionVisaMinBranchIf() {

        val cardType = "Visa"
        val sumLastRemittence = 0
        val remittence = 100

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(35, result)
    }

    @Test
    fun getComissionMirBranchIf() {

        val cardType = "Мир"
        val sumLastRemittence = 0
        val remittence = 100

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(35, result)
    }

    @Test
    fun getComissionVisaMirBranchElse() {

        val cardType = "Visa"
        val sumLastRemittence = 0
        val remittence = 500000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionMirBranchElse() {

        val cardType = "Мир"
        val sumLastRemittence = 0
        val remittence = 500000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionVisaMonthBranchElse() {

        val cardType = "Visa"
        val sumLastRemittence = 590000
        val remittence = 100000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionMirMonthBranchElse() {

        val cardType = "Мир"
        val sumLastRemittence = 590000
        val remittence = 100000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionMaestrodBranchIf() {

        val cardType = "Maestro"
        val sumLastRemittence = 0
        val remittence = 5000
        val result = getComission(cardType, sumLastRemittence, remittence)

        assertEquals(0, result)
    }

    @Test
    fun getComissionMaestroBranchElse() {

        val cardType = "Maestro"
        val sumLastRemittence = 0
        val remittence = 80000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(500, result)
    }

    @Test
    fun getComissionMaestroDailyBranchElse() {

        val cardType = "Maestro"
        val sumLastRemittence = 0
        val remittence = 800000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionMaestroMonthBranchElse() {

        val cardType = "Maestro"
        val sumLastRemittence = 550000
        val remittence = 70000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }


    @Test
    fun getComissionMastercarddBranchIf() {

        val cardType = "Mastercard"
        val sumLastRemittence = 0
        val remittence = 5000
        val result = getComission(cardType, sumLastRemittence, remittence)

        assertEquals(0, result)
    }
    @Test
    fun getComissionMastercardBranchElse() {

        val cardType = "Mastercard"
        val sumLastRemittence = 0
        val remittence = 80000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(500, result)
    }

    @Test
    fun getComissionMastercardDailyBranchElse() {

        val cardType = "Mastercard"
        val sumLastRemittence = 0
        val remittence = 800000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun getComissionMastercardMonthBranchElse() {

        val cardType = "Mastercard"
        val sumLastRemittence = 550000
        val remittence = 70000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun comissionVisaMirBranchIf() {

        val minCommission = 35
        val remittence = 5000

        val result = comissionVisaMir(remittence, minCommission)
        assertEquals(37, result)
    }

    @Test
    fun comissionVisaMirBranchElse() {

        val minCommission = 35
        val remittence = 100

        val result = comissionVisaMir(remittence, minCommission)
        assertEquals(35, result)
    }

    @Test
    fun comissionMaestroMastercardBranchElse() {

        val remittence = 5000
        val result = comissionMaestroMastercard(remittence)

        assertEquals(0, result)
    }

    @Test
    fun comissionMaestroMastercardBranchIf() {

        val remittence = 90000

        val result = comissionMaestroMastercard(remittence)
        assertEquals(560, result)
    }

    @Test
    fun defaultValue(){

        getComission("Vk pay", 0, 5000)
        assertEquals(0, getComission())
    }

    @Test
    fun unknowCard(){
        val cardType = "UnionPay"
        val sumLastRemittence = 0
        val remittence = 1000

        val result = getComission(cardType, sumLastRemittence, remittence)
        assertEquals(ERROR_TYPE, result)
    }
}
