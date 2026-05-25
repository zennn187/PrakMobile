package com.example.ozaapps.Data.API

import com.example.ozaapps.Data.Model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
