package com.espanol.semifinalexam

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBackend(private val adapter: Adapter) {
    private var tweetApiService: RetrofitApi

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://eldroid.online/").addConverterFactory(GsonConverterFactory.create()).build()
        tweetApiService = retrofit.create(RetrofitApi::class.java)
    }

    fun create(request: Request) {
        val call: Call<Data> = tweetApiService.createTweet(request)
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    display()
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {}
        })
    }

    fun modify(id: String, request: Request) {
        val call: Call<Data> = tweetApiService.updateTweet(id, request)
        call.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful) {
                    display()
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {}
        })
    }

    fun delete(id: String) {
        val call: Call<com.espanol.semifinalexam.Response> = tweetApiService.deleteTweet(id)
        call.enqueue(object : Callback<com.espanol.semifinalexam.Response> {
            override fun onResponse(call: Call<com.espanol.semifinalexam.Response>, response: Response<com.espanol.semifinalexam.Response>) {
                if (response.isSuccessful) {
                    display()
                }
            }
            override fun onFailure(call: Call<com.espanol.semifinalexam.Response>, t: Throwable) {}
        })
    }

    fun display() {
        val call: Call<List<Data>> = tweetApiService.getTweets()
        call.enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful) {
                    val data: List<Data> = response.body() ?: emptyList()
                    adapter.update(data)
                }
            }
            override fun onFailure(call: Call<List<Data>>, t: Throwable) {}
        })
    }
}