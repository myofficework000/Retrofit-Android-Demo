package com.example.all_in_one_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.all_in_one_retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    lateinit var apiService: ApiService
    lateinit var retrofit: Retrofit
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        retrofit = RetrofitBuilder.getRetrofit()
        apiService = retrofit.create(ApiService::class.java)
        postComment()
        updatePosts()
        updatePostTitle()
        deletePost()
        getAPost()
        getALlPosts()
        postPosts()
    }


    private fun getAPost() {
        apiService.getPosts("1")
            .enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    Log.i("tag", response.message())
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }


    private fun getALlPosts() {
        apiService.getAllPosts()
            .enqueue(object : Callback<PostAllData> {
                override fun onResponse(
                    call: Call<PostAllData>,
                    response: Response<PostAllData>
                ) {
                    Log.i("tag", response.message())
                }

                override fun onFailure(call: Call<PostAllData>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }


    private fun deletePost() {
        apiService.deletePost("1")
            .enqueue(object : Callback<Unit> {
                override fun onResponse(
                    call: Call<Unit>,
                    response: Response<Unit>
                ) {
                    Log.i("tag", response.message())
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }

    private fun updatePostTitle() {
        apiService.updatePostTitle("1", "London")
            .enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    Log.i("tag", response.body()?.title!!)
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }


    private fun updatePosts() {
        apiService.updatePosts("1", "1", "London", "good city", "1")
            .enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    Log.i("tag", response.body()?.title!!)
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }

    private fun postComment() {
        apiService.postPosts("London", "good city", "1")
            .enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    Log.i("tag", response.body()?.title!!)
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }

    private fun postPosts() {
        apiService.postPosts(PostRequest("London", "good city", "1"))
            .enqueue(object : Callback<PostsResponse> {
                override fun onResponse(
                    call: Call<PostsResponse>,
                    response: Response<PostsResponse>
                ) {
                    Log.i("tag", response.body()?.title!!)
                }

                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {
                    // binding.loader.visibility = View.GONE
                    Log.i("tag", t.message.toString())
                }
            })
    }
}
