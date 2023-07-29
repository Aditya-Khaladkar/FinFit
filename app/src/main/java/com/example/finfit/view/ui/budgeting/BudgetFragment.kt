package com.example.finfit.view.ui.budgeting

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finfit.R
import com.example.finfit.databinding.FragmentBudgetBinding

class BudgetFragment : Fragment() {
    lateinit var binding: FragmentBudgetBinding
    private lateinit var viewModel: BudgetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBudgetBinding.inflate(inflater, container, false)
        val root = binding.root

        //setMonthlyBudget()


        return root
    }

//    private fun setMonthlyBudget() {
//        val dialogView = layoutInflater.inflate(R.layout.monthly_budget_layout, null)
//        val btnCancel = dialogView.btn_cancel
//        val btnOkay = dialogView.btn_okay
//
//        val alertDialogBuilder = AlertDialog.Builder(context)
//            .setView(dialogView)
//            .setCancelable(false)
//
//        val alertDialog = alertDialogBuilder.create()
//
//        btnCancel.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//        btnOkay.setOnClickListener {
//            alertDialog.dismiss()
//        }
//
//        alertDialog.show()
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BudgetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}