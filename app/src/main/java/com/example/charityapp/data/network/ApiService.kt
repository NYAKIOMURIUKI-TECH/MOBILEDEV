package com.example.charityapp.data.network

import com.example.charityapp.data.entities.Organization
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Body

interface ApiService {

    @GET("organizations")
    suspend fun getOrganizations(): Response<List<Organization>>

    @POST("organizations")
    suspend fun createOrganization(@Body organization: Organization): Response<Organization>
}
