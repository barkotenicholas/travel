package com.barkote.travel.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.databinding.FragmentCityListBinding
import java.util.*


class CityListFragment : Fragment() {

    private lateinit var binding: FragmentCityListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

       binding = FragmentCityListBinding.inflate(inflater, container, false)

        setUpRecyclerView()

        return binding.root
    }

    private fun setUpRecyclerView() {

        val context = requireContext()

        val adapter  = CityAdapter(context,VacationSpots.cityList!!)

        val layout = LinearLayoutManager(context)
        layout.orientation = RecyclerView.VERTICAL

        binding.cityRecyclerView.adapter = adapter
        binding.cityRecyclerView.setHasFixedSize(true)
        binding.cityRecyclerView.layoutManager = layout

    }



}