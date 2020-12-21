package com.openclassrooms.realestatemanager.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.RealEstateApplication
import com.openclassrooms.realestatemanager.databinding.DetailsFragmentBinding
import javax.inject.Inject

/**
 * Fragment containing real estate details.
 */
class DetailsFragment : Fragment() {

    /**
     * Factory for creating a viewModel.
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel of the fragment.
     */
    private lateinit var viewModel: DetailsViewModel

    /**
     * Object allowing view binding.
     */
    private var binding: DetailsFragmentBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Declaration that the class will be used for dependence injections.
        (requireActivity().application as RealEstateApplication).appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return this.binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel = ViewModelProvider(this, this.viewModelFactory).get(DetailsViewModel::class.java)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.binding = null
    }
}