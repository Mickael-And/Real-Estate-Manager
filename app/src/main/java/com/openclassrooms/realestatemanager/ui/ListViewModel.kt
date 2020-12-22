package com.openclassrooms.realestatemanager.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.realestatemanager.data.RealEstate
import com.openclassrooms.realestatemanager.data.RealEstateType
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

/**
 * ViewModel of ListFragment.
 */
class ListViewModel @Inject constructor() : ViewModel() {

    /**
     * List of real estate.
     */
    val realEstates: MutableLiveData<ArrayList<RealEstate>> by lazy {
        MutableLiveData<ArrayList<RealEstate>>()
    }

    init {
        this.realEstates.value = dummyRealEstates()
    }

    /**
     * Provide a dummy list of real estate.
     */
    private fun dummyRealEstates(): ArrayList<RealEstate> {
        val realEstate1 = RealEstate(RealEstateType.APPARTMENT, BigDecimal(150000), 95.5, 2, "Good appartment", ArrayList(), "1 rue de l'herbelière",
                "School, transport", false, Date(System.currentTimeMillis()), Date(System.currentTimeMillis()), "Agent 1")
        val realEstate2 = RealEstate(RealEstateType.BUILDING_PLOT, BigDecimal(1000), 2000.0, 0, "Good plot", ArrayList(), "2 rue de l'herbelière",
                "Transport", false, Date(System.currentTimeMillis()), Date(System.currentTimeMillis()), "Agent 2")
        val realEstate3 = RealEstate(RealEstateType.HOUSE, BigDecimal(350000), 165.4, 3, "Good house", ArrayList(), "3 rue de l'herbelière",
                "School", false, Date(System.currentTimeMillis()), Date(System.currentTimeMillis()), "Agent 3")
        val realEstate4 = RealEstate(RealEstateType.LOFT, BigDecimal(1550000), 400.0, 5, "Good loft", ArrayList(), "4 rue de l'herbelière",
                "Beach", false, Date(System.currentTimeMillis()), Date(System.currentTimeMillis()), "Agent 4")
        val realEstate5 = RealEstate(RealEstateType.RESIDENCE, BigDecimal(3150000), 1000.0, 10, "Good residence", ArrayList(), "5 rue de l'herbelière",
                "Bus", false, Date(System.currentTimeMillis()), Date(System.currentTimeMillis()), "Agent 5")

        return ArrayList(listOf(realEstate1, realEstate2, realEstate3, realEstate4, realEstate5))
    }
}