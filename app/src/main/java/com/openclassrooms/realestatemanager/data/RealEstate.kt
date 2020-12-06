package com.openclassrooms.realestatemanager.data

import java.math.BigDecimal
import java.time.LocalDate

/**
 * Represents real estate.
 */
data class RealEstate(var type: String, var price: BigDecimal, var space: Double, var roomNumber: Byte, var description: String, var photos: List<String>,
                      var address: String, var nearbyInterestPoints: String, var status: Boolean, var entryDate: LocalDate, var saleDate: LocalDate, var agent: String) {
}