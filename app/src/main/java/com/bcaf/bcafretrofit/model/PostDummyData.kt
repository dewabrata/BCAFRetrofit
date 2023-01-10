package com.bcaf.bcafretrofit.model

import com.google.gson.annotations.SerializedName

data class PostDummyData(

	@field:SerializedName("owner")
	val owner: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("likes")
	val likes: Int? = null,

	@field:SerializedName("tags")
	val tags: List<String?>? = null
)

