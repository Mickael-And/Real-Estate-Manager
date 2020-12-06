package com.openclassrooms.realestatemanager.data

import com.openclassrooms.realestatemanager.R

/**
 * Represents the type of real estate.
 */
enum class RealEstateType(val stringId: Int) {
    APPARTMENT(R.string.appartment_type),
    HOUSE(R.string.house_type),
    BUILDING_PLOT(R.string.building_plot_type),
    RESIDENCE(R.string.residence_type),
    LOFT(R.string.loft_type)
}