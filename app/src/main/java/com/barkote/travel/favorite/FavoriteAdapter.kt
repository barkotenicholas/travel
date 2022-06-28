package com.sriyank.globotour.favorite

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.R
import com.barkote.travel.city.City
import com.barkote.travel.databinding.ListItemFavoriteBinding


class FavoriteAdapter(val context: Context, var favCityList: ArrayList<City>): RecyclerView.Adapter<FavoriteAdapter.FavCityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavCityViewHolder {

        val binding  = ListItemFavoriteBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavCityViewHolder(binding)
    }

    override fun getItemCount(): Int = favCityList.size

    override fun onBindViewHolder(itemViewHolder: FavCityViewHolder, position: Int) {

        val city = favCityList[position]
        itemViewHolder.setData(city, position)
    }

    inner class FavCityViewHolder(private val binding: ListItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {

        private var currentPosition: Int = -1
        private var currentCity: City?   = null


        fun setData(city: City, position: Int) {
            this.currentPosition = position
            this.currentCity = city
            binding.txvCityName.text = city.name
            binding.imvCity.setImageResource(city.imageId)


        }
    }
}
