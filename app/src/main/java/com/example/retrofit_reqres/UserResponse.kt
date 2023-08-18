package com.example.retrofit_reqres

import com.google.gson.annotations.SerializedName

// algo expecifico
//representacao da resposta de usuario
data class UserResponse(

    // para cada um vou fazer uma estrutura dedados
    @SerializedName("id") var id:Int? = 0, // id do tipo int que vai ter valor padrao 0

    @SerializedName("email") var email:String? = "",

    @SerializedName("first_name") var first_name: String? = "",

    @SerializedName("last_name") var last_name: String? = "",

    @SerializedName("avatar") var avatar: String? = "",



    )
