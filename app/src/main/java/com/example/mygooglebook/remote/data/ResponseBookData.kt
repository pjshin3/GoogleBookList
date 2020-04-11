package com.example.mygooglebook.remote.data

import com.google.gson.annotations.SerializedName

data class ResponseBookData(
    @SerializedName("totalItems") val totalItems : String,
    @SerializedName("items") val items : ArrayList<Items>
)

data class Items(
    @SerializedName("volumeInfo") val volumeInfo : VolumeInfoList
)

data class VolumeInfoList(
    @SerializedName("title") val title : String,
    @SerializedName("authors") val authors :  List<String>,
    @SerializedName("imageLinks") val imageLinks : ImageLinksList,
    @SerializedName("publishedDate") val publishedDate : String,
    @SerializedName("publisher") val publisher : String,
    @SerializedName("description") val description : String,
    @SerializedName("infoLink") val infoLink : String

)

data class ImageLinksList(
    @SerializedName("smallThumbnail") val smallThumbnail : String
)