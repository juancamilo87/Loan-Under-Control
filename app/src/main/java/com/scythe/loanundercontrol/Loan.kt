package com.scythe.loanundercontrol

import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

/**
 * Created by Camilo on 5/6/2018.
 */
data class Loan(val name: String,
                val initialDebt: BigDecimal,
                val startDate: LocalDate,
                val paymentList: Array<Payment>,
                val currency: Currency) {

    val amountLeft: BigDecimal
        get() = initialDebt - paymentList.sumByBigDecimal { it.amount }


    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Loan

        if (name != other.name) return false
        if (initialDebt != other.initialDebt) return false
        if (startDate != other.startDate) return false
        if (!Arrays.equals(paymentList, other.paymentList)) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + initialDebt.hashCode()
        result = 31 * result + startDate.hashCode()
        result = 31 * result + Arrays.hashCode(paymentList)
        result = 31 * result + currency.hashCode()
        return result
    }
}
