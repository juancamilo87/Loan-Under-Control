package com.scythe.loanundercontrol

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.NumberFormat

/**
 * Created by Camilo on 5/6/2018.
 */
class LoansAdapter(private val loansList: Array<Loan>) :
        RecyclerView.Adapter<LoansAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val loanName = view.findViewById<TextView>(R.id.loan_name_tv)!!
        val leftToPay = view.findViewById<TextView>(R.id.loan_left_to_pay_tv)!!
        val totalDebt = view.findViewById<TextView>(R.id.loan_initial_debt_tv)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoansAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.loan_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val loan = loansList[position]
        val formatter = NumberFormat.getCurrencyInstance()
        formatter.currency = loan.currency
        formatter.maximumFractionDigits = loan.currency.defaultFractionDigits
        holder.apply {
            loanName.text = loan.name
            totalDebt.text = formatter.format(loan.initialDebt)
            leftToPay.text = formatter.format(loan.amountLeft)
        }
    }

    override fun getItemCount() = loansList.size

}