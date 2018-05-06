package com.scythe.loanundercontrol

import java.math.BigDecimal
import java.time.LocalDate

/**
 * Created by Camilo on 5/6/2018.
 */
data class Payment(val date: LocalDate, val amount: BigDecimal)