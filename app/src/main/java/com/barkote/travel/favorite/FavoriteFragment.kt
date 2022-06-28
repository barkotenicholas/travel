package com.barkote.travel.favorite
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.R
import com.barkote.travel.city.City
import com.barkote.travel.city.VacationSpots
import com.barkote.travel.databinding.FragmentCityListBinding
import com.barkote.travel.databinding.FragmentFavoriteBinding
import com.sriyank.globotour.favorite.FavoriteAdapter


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val context = requireContext()

        val favoriteCityList = VacationSpots.favoriteCityList as ArrayList<City>
        val favoriteAdapter = FavoriteAdapter(context, favoriteCityList)

        binding.favrecylerview.adapter = favoriteAdapter
        binding.favrecylerview.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.favrecylerview.layoutManager = layoutManager
    }
}
