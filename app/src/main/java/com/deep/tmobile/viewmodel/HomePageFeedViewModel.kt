package com.deep.tmobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deep.tmobile.data.HomePageFeedDataClass
import com.deep.tmobile.network.NetworkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model to hold business logic and to make server call
 */
class HomePageFeedViewModel : ViewModel() {

    /**
     * Live data that will hold the data and post any changes happens to data to observables
     */
    private var _homePageFeedListLiveData = MutableLiveData<HomePageFeedDataClass>()
    val homePageFeedListLiveData: LiveData<HomePageFeedDataClass>
        get() = _homePageFeedListLiveData


    /**
     * Public method to initiate server get call to get feed
     */
    fun getHomePageFeedList() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroService = NetworkManager.getRetrofitService()
            val homePageFeedDataClass = retroService.getHomePageFeedApi()
            _homePageFeedListLiveData.postValue(homePageFeedDataClass)
        }
    }
}