package com.example.indianjokesapplication.main_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.indianjokesapplication.dao.MyDatabase
import com.example.indianjokesapplication.dao.Repo
import com.example.indianjokesapplication.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var database: MyDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application
        val adapter = MyAdapter()
        val dao = database.getDao()
        val repo = Repo(dao)

        database = MyDatabase.getDatabase(application)
        val viewModel : MainViewModel by viewModels()








        binding.recyclerView.adapter = adapter
        binding.xmlViewModelVariable = viewModel
        viewModel.liveList.observe(viewLifecycleOwner , Observer {
            adapter.submitList(it)

        })








        binding.executePendingBindings()
        binding.lifecycleOwner = this

        return binding.root

    }
}