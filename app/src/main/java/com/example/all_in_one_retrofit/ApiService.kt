package com.example.all_in_one_retrofit

import com.example.all_in_one_retrofit.Constant.END_POINT
import retrofit2.Call
import retrofit2.http.*

/*
This class all kinds of Retrofit requests
@GET,
@POST,
@PUT,
@PATCH,
@DELETE
*/
interface ApiService {

    /*
    In this API call we are fetching a post on the basis of post id
    */
    @GET("posts/{postId}")
    fun getPosts(
        @Path("postId") postId: String,
    ): Call<PostsResponse>

    /*
    In this API call we are fetching all the posts available
    */
    @GET(END_POINT)
    fun getAllPosts(): Call<PostAllData>

    /*
    In this API call we are adding a new post by using field
    */
    @FormUrlEncoded
    @POST(END_POINT)
    fun postPosts(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: String
    ): Call<PostsResponse>

    /*
    In this API call we are adding a new post by using body
    */
    @POST(END_POINT)
    fun postPosts(@Body postRequest: PostRequest): Call<PostsResponse>

    /*
   In this API call we are update the post details
   */
    @FormUrlEncoded
    @PUT("posts/{postId}")
    fun updatePosts(
        @Path("postId") postId: String,
        @Field("id") id: String,
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: String
    ): Call<PostsResponse>


    @FormUrlEncoded
    @PATCH("posts/{postId}")
    fun updatePostTitle(
        @Path("postId") id: String, @Field("title") title: String
    ): Call<PostsResponse>

    /*
    In this API call we are deleting a post on the basis of post Id
    received as parameter
    */
    @DELETE("posts/{id}")
    fun deletePost(@Path("id") id: String): Call<Unit>
}