package com.openclassrooms.realestatemanager.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.ui.DetailsViewModel
import com.openclassrooms.realestatemanager.ui.ListViewModel
import com.openclassrooms.realestatemanager.ui.MainActivityViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

/**
 * Module providing the ViewModel instances used in the application.
 */
@Module
abstract class ViewModelModule {

    /**
     * Provide factory allowing the creation of ViewModels of the application.
     */
    @Binds
    abstract fun bindViewModelFactory(factory: RealEstateViewModelFactory): ViewModelProvider.Factory

    @Target(AnnotationTarget.FUNCTION,
            AnnotationTarget.PROPERTY_GETTER,
            AnnotationTarget.PROPERTY_SETTER)
    @Retention(AnnotationRetention.RUNTIME)
    @MapKey
    annotation class ViewModelKey(val value: KClass<out ViewModel>)

    /**
     * Provide MainActivityViewModel instance.
     */
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    /**
     * Provide ListViewModel instance.
     */
    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    /**
     * Provide DetailsViewModel instance.
     */
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel
}