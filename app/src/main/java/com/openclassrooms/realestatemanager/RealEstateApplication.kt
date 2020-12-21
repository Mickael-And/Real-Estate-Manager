package com.openclassrooms.realestatemanager

import android.app.Application
import com.openclassrooms.realestatemanager.di.AppComponent
import com.openclassrooms.realestatemanager.di.DaggerAppComponent

/**
 * Represents the instance of the application. Used to obtain the application context for Dagger.
 */
open class RealEstateApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}