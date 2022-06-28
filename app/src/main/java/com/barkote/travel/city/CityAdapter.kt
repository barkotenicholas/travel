package com.barkote.travel.city

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.barkote.travel.R
import com.barkote.travel.databinding.GridItemCityBinding
import com.barkote.travel.databinding.ListItemCityBinding

class CityAdapter(val context:Context , var cityList: ArrayList<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(private val binding: GridItemCityBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {


        private var currentPosition = -1
        private var currentCity :City ? =null
        private val icFavoriteFilledImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_filled, null)
        private val icFavoriteBorderedImage = ResourcesCompat.getDrawable(context.resources,
            R.drawable.ic_favorite_bordered, null)
        fun bind(city: City, position: Int) {

            this.currentPosition = position

            binding.txvCityName.text = city.name
            binding.imvCity.setImageResource(city.imageId)

            if(city.isFavourite)
                binding.imvFavorite.setImageDrawable(icFavoriteFilledImage)
            else
                binding.imvFavorite.setImageDrawable(icFavoriteBorderedImage)

        }

        fun setListeners() {
            binding.imvDelete.setOnClickListener(this@CityViewHolder)
            binding.imvFavorite.setOnClickListener(this@CityViewHolder)
        }

        override fun onClick(v: View?) {
            when(v!!.id){
                R.id.imv_favorite -> addFavourite()
                R.id.imv_favorite -> deleteItem()
            }
        }

        private fun deleteItem() {
            cityList.removeAt(currentPosition)
            notifyItemRemoved(currentPosition)
            notifyItemRangeChanged(currentPosition,cityList.size)
        }

        private fun addFavourite() {
            TODO("Not yet implemented")
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        val binding  = GridItemCityBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CityViewHolder(binding)

    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cityList[position],position)
        holder.setListeners()
    }

    override fun getItemCount(): Int = cityList.size

}

