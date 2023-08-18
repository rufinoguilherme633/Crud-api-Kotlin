package com.example.retrofit_reqres

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @GET("/api/users/{id}")

    //descrcao da acao requisicao
    suspend fun getUserByID(@Path("id") id: String): Response<BaseResponse<UserResponse>>//suspend fun -> assinc -> vai receber resposta de alguem entao espere a resposta
    // esse id do tipo String vai ser o id do caminho do Get
//Path-> trilha passar o id
    //Reposnse E o retorno String
    //18/08
    @POST("/api/users/")
    //mandar dados
    suspend fun createUser(@Body body: JsonObject): Response<JsonObject> //JsonO -> google devolve e manda Json

    @PUT("/api/users/{id}")
    suspend fun updateUser(@Path("id") id:String, @Body body: JsonObject) : Response<JsonObject> // alem de esperar um id ele manda dados e a juncao dos dpois anteriores


    @DELETE("/api/users/{id}")
    suspend fun deleteUser(@Path("id") id: String): Response<JsonObject>

}