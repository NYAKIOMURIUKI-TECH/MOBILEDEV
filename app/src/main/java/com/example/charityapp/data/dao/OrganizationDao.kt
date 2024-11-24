package com.example.charityapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.charityapp.data.entities.Organization
import androidx.lifecycle.LiveData

@Dao
interface OrganizationDao {
    @Query("SELECT * FROM organizations ORDER BY name")
    fun getAllOrganizations(): LiveData<List<Organization>>

    @Query("SELECT * FROM organizations WHERE name LIKE :query OR category LIKE :query")
    fun searchOrganizations(query: String): LiveData<List<Organization>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(organizations: List<Organization>)
}
