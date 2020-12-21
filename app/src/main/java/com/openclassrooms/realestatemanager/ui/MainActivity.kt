package com.openclassrooms.realestatemanager.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.RealEstateApplication
import com.openclassrooms.realestatemanager.databinding.ActivityMainBinding
import javax.inject.Inject

/**
 *
Represents the main activity. This is the activity of launching the application.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Class used to bind XML views to code.
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * Factory for creating a viewModel.
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel of the activity.
     */
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Declaration that the class will be used for dependence injections.
        (application as RealEstateApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.viewModel = ViewModelProvider(this, this.viewModelFactory).get(MainActivityViewModel::class.java)
    }
}