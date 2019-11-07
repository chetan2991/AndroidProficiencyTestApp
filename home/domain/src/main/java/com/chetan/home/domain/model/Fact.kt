package com.chetan.home.domain.model

import androidx.databinding.BaseObservable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.chetan.base.data.network.Json
import com.google.gson.annotations.SerializedName
@Entity(tableName = "fact")
@Json
data class Fact constructor(
    @PrimaryKey(autoGenerate = true) var id : Long? = null,
    @field:SerializedName("description")var description: String?="",
    @field:SerializedName("imageHref")var imageHref: String?="",
    @field:SerializedName(  "title")var title: String?="",
    @Ignore
    val palette: String?=""

): BaseObservable(){
    companion object{
        val EMPTY = Fact(
            title = "",
            description = "",
            imageHref =  "",
            id = 0,
            palette = ""
        )
    }
}