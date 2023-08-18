package com.example.retrofit_reqres

import com.google.gson.annotations.SerializedName
//anotac;oes ligadas ao nome
data class BaseResponse<T>( // T -> representa uma generalizacao baseResponse e uma generalizacao
    @SerializedName("data")// uma forma de fazer anotações de estrutura de dados vai criar um objeto para
    var data: T? = null
)
