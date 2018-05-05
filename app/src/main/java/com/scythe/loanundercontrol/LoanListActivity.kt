package com.scythe.loanundercontrol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_loan_list.*
import java.time.LocalDate
import java.util.*

class LoanListActivity : AppCompatActivity() {

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loan_list)

        setupLoansList()
    }

    private fun setupLoansList() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = LoansAdapter(createFakeLoanList())

        loans_rv.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    private fun createFakeLoanList() : Array<Loan> {
        return arrayOf(
                Loan("First loan", 15000.45.bd,
                        LocalDate.of(2018, 5, 1),
                        emptyArray(), Currency.getInstance("EUR")),
                Loan("Second loan", 18000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("USD")),
                Loan("Third loan", 18000000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("COP")),
                Loan("Fourth loan", 17000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("JPY")),
                Loan("First loan", 15000.45.bd,
                        LocalDate.of(2018, 5, 1),
                        emptyArray(), Currency.getInstance("EUR")),
                Loan("Second loan", 18000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("USD")),
                Loan("Third loan", 18000000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("COP")),
                Loan("Fourth loan", 17000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("JPY")),
                Loan("First loan", 15000.45.bd,
                        LocalDate.of(2018, 5, 1),
                        emptyArray(), Currency.getInstance("EUR")),
                Loan("Second loan", 18000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("USD")),
                Loan("Third loan", 18000000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("COP")),
                Loan("Fourth loan", 17000.bd,
                        LocalDate.of(2017, 4, 12),
                        emptyArray(), Currency.getInstance("JPY"))
        )
    }
}
