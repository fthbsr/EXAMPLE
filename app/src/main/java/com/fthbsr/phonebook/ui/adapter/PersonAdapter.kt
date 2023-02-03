package com.fthbsr.phonebook.ui.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fthbsr.phonebook.Data.Person
import com.fthbsr.phonebook.R
import com.fthbsr.phonebook.ui.MainPageFragment
import com.fthbsr.phonebook.ui.ViewModel.MainViewModel

class PersonAdapter(
    private val myList: List<Person>,
    private val viewModel: MainViewModel,
    private val mainPageFragment: MainPageFragment,
) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personName: TextView
        val deleteBtn: ImageView

        init {
            personName = view.findViewById(R.id.personName)
            deleteBtn = view.findViewById(R.id.deleteButton)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = myList[position].name

        holder.itemView.setOnClickListener {
            mainPageFragment.showDetailPage(it, myList[position])
        }

        holder.deleteBtn.setOnClickListener {
            if (position >= 0 && myList.size > position) {
                viewModel.deletePerson(mainPageFragment.requireContext(),myList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }




}