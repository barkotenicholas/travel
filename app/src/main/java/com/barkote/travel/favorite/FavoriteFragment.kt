package com.barkote.travel.favorite
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.R
import com.barkote.travel.city.City
import com.barkote.travel.city.VacationSpots
import com.barkote.travel.databinding.FragmentCityListBinding
import com.barkote.travel.databinding.FragmentFavoriteBinding
import com.sriyank.globotour.favorite.FavoriteAdapter
import java.util.*
import kotlin.collections.ArrayList


class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var favoriteCityList : ArrayList<City>
    private lateinit var favoriteAdapter : FavoriteAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        setUpRecyclerView()
        return binding.root
    }

    private fun setUpRecyclerView() {
        val context = requireContext()

        favoriteCityList = VacationSpots.favoriteCityList as ArrayList<City>
        favoriteAdapter  = FavoriteAdapter(context, favoriteCityList)

        binding.favrecylerview.adapter = favoriteAdapter
        binding.favrecylerview.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.favrecylerview.layoutManager = layoutManager

        itemTouchHelper.attachToRecyclerView(binding.favrecylerview)
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,0){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            val from = viewHolder.adapterPosition
            val to   = target.adapterPosition

            Collections.swap(favoriteCityList,from,to)

            favoriteAdapter.notifyItemMoved(from,to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }

    })
}
