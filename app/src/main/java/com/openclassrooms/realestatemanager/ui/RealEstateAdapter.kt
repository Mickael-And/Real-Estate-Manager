package com.openclassrooms.realestatemanager.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.data.RealEstate
import com.openclassrooms.realestatemanager.databinding.RealEstateItemBinding
import java.util.*

/**
 * Adapter that can display a RealEstate.
 */
class RealEstateAdapter(private var realEstateList: ArrayList<RealEstate>) : RecyclerView.Adapter<RealEstateAdapter.RealEstateViewHolder>() {

    /**
     * ViewHolder containing an item.
     */
    class RealEstateViewHolder(val binding: RealEstateItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
        val binding = RealEstateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RealEstateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        val realEstate: RealEstate = realEstateList[position]
        holder.binding.type.setText(holder.itemView.context.getText(realEstate.type.stringId))
        holder.binding.city.setText(realEstate.address)
        holder.binding.price.setText(String.format(Locale.getDefault(), "\$%,.0f", realEstate.price.toDouble()))
        Glide.with(holder.itemView).load(R.drawable.exemple_maison).into(holder.binding.image)
        // TODO: Replace the exemple_maison with real estate image
    }

    override fun getItemCount(): Int = realEstateList.size

    /**
     * Updates the list of real estate to display.
     */
    fun updateList(realEstates: ArrayList<RealEstate>) {
        this.realEstateList = realEstates
        notifyDataSetChanged()
    }
}