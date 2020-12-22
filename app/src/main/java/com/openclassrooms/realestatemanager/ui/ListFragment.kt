package com.openclassrooms.realestatemanager.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.RealEstateApplication
import com.openclassrooms.realestatemanager.databinding.ListFragmentBinding
import javax.inject.Inject

/**
 * Fragment containing real estate list.
 */
class ListFragment : Fragment() {

    /**
     * Object allowing view binding.
     */
    private var binding: ListFragmentBinding? = null

    /**
     * Factory for creating a viewModel.
     */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel of the fragment.
     */
    private lateinit var viewModel: ListViewModel

    /**
     * Real estate list adapter.
     */
    private lateinit var realEstateAdapter: RealEstateAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Declaration that the class will be used for dependence injections.
        (requireActivity().application as RealEstateApplication).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = ViewModelProvider(this, this.viewModelFactory).get(ListViewModel::class.java)
        this.viewModel.realEstates.observe(this, { realEstates -> this.realEstateAdapter.updateList(realEstates) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.binding = ListFragmentBinding.inflate(inflater, container, false)
        return this.binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.realEstateAdapter = RealEstateAdapter(ArrayList())
        this.binding?.realEstatesList?.adapter = this.realEstateAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this.binding = null
    }
}