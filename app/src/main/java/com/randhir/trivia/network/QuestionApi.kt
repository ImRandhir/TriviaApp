package com.randhir.trivia.network

import com.randhir.trivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json") // world.json is path after the base url in Constants.kt
    suspend fun getAllQuestions(): Question
}