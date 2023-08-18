package com.example.retrofit_reqres

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// instacia do retofin
object RetrofitHelper {
    //acessar o reqres -> site
    //URL base
    private  const val baseUrl = " https://reqres.in"

    //criando a conexao -> metodo para resolver conexao para quando chamar abrir a conexao

    fun getInstace(): Retrofit {
        // espera um retorno de um objeto
        return Retrofit.Builder() //retorno do retofif do Bulder(para construir)
            .baseUrl(baseUrl)
            //fabrica de conversao -> para conveter o objeto json para o retrofit manipula-lo
            .addConverterFactory(GsonConverterFactory.create())
            .build() //para construir
    }

}


