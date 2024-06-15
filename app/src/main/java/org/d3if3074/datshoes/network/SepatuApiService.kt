package org.d3if3074.datshoes.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if3074.datshoes.model.OpStatus
import org.d3if3074.datshoes.model.Sepatu
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

private const val BASE_URL = "https://rest-api-rizqynurf-shoes.000webhostapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SepatuApiService {
    @GET("api/shoes.php")
    suspend fun getSepatu(
        @Header("Authorization") userId: String,
    ): List<Sepatu>

    @Multipart
    @POST("api/shoes.php")
    suspend fun postSepatu(
        @Header("Authorization") userId: String,
        @Part("merk") merk: RequestBody,
        @Part("jenisSepatu") jenisSepatu: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @FormUrlEncoded
    @POST("api/deleteShoes.php")
    suspend fun deleteSepatu(
        @Header("Authorization") userId: String,
        @Field("id") sepatuId: String
    ): OpStatus
}


object SepatuApi {
    val service: SepatuApiService by lazy {
        retrofit.create(SepatuApiService::class.java)
    }

    fun getSepatuUrl(imageId: String): String {
        return "${BASE_URL}api/image.php?id=$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }