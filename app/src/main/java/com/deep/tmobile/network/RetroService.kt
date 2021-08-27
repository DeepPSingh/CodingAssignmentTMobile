package com.deep.tmobile.network

import com.deep.tmobile.data.HomePageFeedDataClass
import retrofit2.http.GET

/**
 * Retrofit service class that holds or the api calls
 */
interface RetroService {

    @GET("home")
    suspend fun getHomePageFeedApi() : HomePageFeedDataClass

}