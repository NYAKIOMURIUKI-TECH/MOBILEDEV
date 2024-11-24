package com.example.charityapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.charityapp.data.entities.Organization
import com.example.charityapp.data.dao.OrganizationDao

@Database(entities = [Organization::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun organizationDao(): OrganizationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "charity_app_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
