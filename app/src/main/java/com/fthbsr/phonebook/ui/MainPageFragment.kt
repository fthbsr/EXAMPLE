package com.fthbsr.phonebook.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.fthbsr.phonebook.Data.Person
import com.fthbsr.phonebook.R
import com.fthbsr.phonebook.databinding.FragmentMainPageBinding
import com.fthbsr.phonebook.ui.ViewModel.MainViewModel
import com.fthbsr.phonebook.ui.adapter.PersonAdapter

class MainPageFragment : Fragment() {
    private var _binding: FragmentMainPageBinding? = null
    val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.RecylerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PersonAdapter(viewModel.list.value!!, viewModel, this)
        binding.RecylerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner) {
           Log.e("deneme" ,"oldu")
        }



        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.newPerson)
        }
        return binding.root
    }

    fun showDetailPage(it: View, personInfo: Person) {
        val nav = MainPageFragmentDirections.updatePerson(personInfo)
        Navigation.findNavController(it).navigate(nav)
    }
}




