package com.barkote.travel.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.databinding.FragmentCityListBinding


class CityListFragment : Fragment() {

    private lateinit var binding: FragmentCityListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

       binding = FragmentCityListBinding.inflate(inflater, container, false)

        setUpRecyclerView(view)

        return binding.root
    }

    private fun setUpRecyclerView(view: View?) {

        val context = requireContext()

        val adapter  = CityAdapter(context,VacationSpots.cityList!!)

        val layout = GridLayoutManager(context,2)
        layout.orientation = RecyclerView.VERTICAL

        binding.cityRecyclerView.adapter = adapter
        binding.cityRecyclerView.setHasFixedSize(true)
        binding.cityRecyclerView.layoutManager = layout

    }


}