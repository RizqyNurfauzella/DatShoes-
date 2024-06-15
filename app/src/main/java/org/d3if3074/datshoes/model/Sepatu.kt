package org.d3if3074.datshoes.model

import com.squareup.moshi.Json

data class Sepatu(
    val id: String,
    @Json(name = "merk")val merk: String,
    @Json(name = "jenis")val jenisSepatu: String,
    @Json(name = "image_id") val imageId: String,
)