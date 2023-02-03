package com.fthbsr.phonebook.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.fthbsr.phonebook.databinding.FragmentUpdatePageBinding
import com.fthbsr.phonebook.ui.ViewModel.MainViewModel


class UpdatePageFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()
    private var _binding: FragmentUpdatePageBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdatePageBinding.inflate(inflater, container, false)
            val bundle : UpdatePageFragmentArgs by  navArgs()
            binding.updateuserNameText.setText(bundle.person.name)
            binding.updateUserNumberText.setText(bundle.person.number.toString())

        binding.updateUserInfo.setOnClickListener {
            updateInfo(requireContext(),bundle.person.id , binding.updateuserNameText.text.toString(),binding.updateUserNumberText.text.toString().toInt(),it)
        }
        return binding.root
    }
    fun updateInfo(context :Context,id:Int , name: String ,number: Int, it:View){
            viewModel.updateUserInfo(context,id,name,number,it)
    }
}



