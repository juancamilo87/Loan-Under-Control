package com.scythe.loanundercontrol

import java.math.BigDecimal

/**
 * Created by Camilo on 5/6/2018.
 */
inline fun <T> Array<T>.sumByBigDecimal(selector: (T) -> BigDecimal): BigDecimal {
    var sum: BigDecimal = BigDecimal.ZERO
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

val Int.bd: BigDecimal
    get() = BigDecimal(this)

val Double.bd: BigDecimal
    get() = BigDecimal(this)