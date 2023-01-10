package com.bcaf.bcafretrofit.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bcaf.bcafretrofit.model.PostDummyData

@Dao
interface DummyDao {

    @Insert
    fun insertDummy(dummyData:PostDummyData)

    @Delete
    fun deteleDummy(dummyData:PostDummyData)

    @Query("Select * from PostDummyData")
    fun getAll():List<PostDummyData>
}