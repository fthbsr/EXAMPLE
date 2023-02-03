package com.fthbsr.phonebook.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.fthbsr.phonebook.databinding.FragmentNewRecordPageBinding
import com.fthbsr.phonebook.ui.ViewModel.MainViewModel

class NewRecordPageFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentNewRecordPageBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewRecordPageBinding.inflate(inflater, container, false)

        binding.newUserCreate.setOnClickListener {
            var name = binding.newUserNameText.text.toString()
            var number = binding.newUserNumberText.text.toString()
            viewModel.addNewUser(requireContext(), name, number.toInt())
        }
        return binding.root
    }
}