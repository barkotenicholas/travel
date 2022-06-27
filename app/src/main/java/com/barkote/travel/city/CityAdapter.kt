package com.barkote.travel.city

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.R
import com.barkote.travel.databinding.ListItemCityBinding

class CityAdapter(val context:Context , var cityList: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(private val binding: ListItemCityBinding) : RecyclerView.ViewHolder(binding.root) {


        private var currentPosition = -1
        private var currentCity :City ? =null
        private val icFavoriteFilledImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_filled, null)
        private val icFavoriteBorderedImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_bordered, null)
        fun bind(city: City, position: Int) {

            binding.txvCityName.text = city.name
            binding.imvCity.setImageResource(city.imageId)

            if(city.isFavourite)
                binding.imvFavorite.setImageDrawable(icFavoriteFilledImage)
            else
                binding.imvFavorite.setImageDrawable(icFavoriteBorderedImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val binding  = ListItemCityBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CityViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position],position)
    }

    override fun getItemCount(): Int = cityList.size

}

