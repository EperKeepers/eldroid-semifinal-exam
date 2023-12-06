package com.espanol.semifinalexam

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface RetrofitApi {
    @GET("tweet/espanol")
    fun getTweets(): Call<List<Data>>

    @GET("tweet/espanol/{tweetId}")
    fun getTweetDetails(@Path("tweetId") tweetId: String): Call<Data>

    @POST("tweet/espanol")
    fun createTweet(@Body request: Request): Call<Data>

    @PUT("tweet/espanol/{tweetId}")
    fun updateTweet(@Path("tweetId") tweetId: String, @Body request: Request): Call<Data>

    @DELETE("tweet/espanol/{tweetId}")
    fun deleteTweet(@Path("tweetId") tweetId: String): Call<Response>
}