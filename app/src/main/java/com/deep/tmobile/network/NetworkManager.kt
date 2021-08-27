package com.deep.tmobile.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Manager class to initiate Retrofit for make server calls
 */
class NetworkManager {

    companion object {
        private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/"

        /**
         * Initialize retrofit
         */
        private fun getRetroInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        /**
         * Get retrofit service
         */
        fun getRetrofitService(): RetroService {
            return getRetroInstance().create(RetroService::class.java)
        }
    }
}