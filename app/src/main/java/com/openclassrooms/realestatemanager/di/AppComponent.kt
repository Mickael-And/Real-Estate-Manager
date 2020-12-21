package com.openclassrooms.realestatemanager.di

import android.content.Context
import com.openclassrooms.realestatemanager.ui.DetailsFragment
import com.openclassrooms.realestatemanager.ui.ListFragment
import com.openclassrooms.realestatemanager.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Graph Dagger containing the components needed for dependency injection.
 */
@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    // Declaration of the classes which require an injection.
    fun inject(mainActivity: MainActivity)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(listFragment: ListFragment)
}