package com.deep.tmobile.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deep.tmobile.R
import com.deep.tmobile.ui.adapter.HomePageFeedAdapter
import com.deep.tmobile.viewmodel.HomePageFeedViewModel

/**
 * This fragment class is being used to display current feed
 */
class HomePageFeedFragment : Fragment() {

    private lateinit var homePageFeedAdapter : HomePageFeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home_page_feed, container, false)
        initializeControls(view)
        initializeViewModel()
        return view
    }

    /**
     * Initialize all the UI controls here
     */
    private fun initializeControls(view : View) {
        val homePageFeedRecyclerView = view.findViewById<RecyclerView>(R.id.homePageFeedRecyclerView)
        homePageFeedRecyclerView.layoutManager = LinearLayoutManager(activity)
        homePageFeedAdapter = HomePageFeedAdapter()
        homePageFeedRecyclerView.adapter = homePageFeedAdapter
    }

    /**
     * Initialize view model
     */
    private fun initializeViewModel() {
        val homePageFeedViewModel = ViewModelProvider(this)[HomePageFeedViewModel::class.java]
        homePageFeedViewModel.homePageFeedListLiveData.observe(viewLifecycleOwner, {
            if(it != null){
                homePageFeedAdapter.setUpdatedData(it.page.cards)
            } else {
                Toast.makeText(activity, "Error in getting the data", Toast.LENGTH_SHORT).show()
            }
        })
        homePageFeedViewModel.getHomePageFeedList()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomePageFeedFragment()
    }
}