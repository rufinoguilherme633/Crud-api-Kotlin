package com.example.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.create


// importacoes

class MainActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService //instancia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstace()
            .create(ApiService::class.java) //ApiService conectado no RetrofitHelper

        //Ação do botao GET
        // procura um componente grafico pelo id
        //tornando o botao utilizavel
        findViewById<Button>(R.id.btnGet).setOnClickListener {// todos os id estao dentro do R
            getUserByID() // mesmo nome do APIService para fazer associacao e nome do metodo a baixo
        }

        //acao do botao POST:
        findViewById<Button>(R.id.btnPOST).setOnClickListener {// todos os id estao dentro do R
            createUser() // mesmo nome do APIService para fazer associacao e nome do metodo a baixo
        }

        //acao do botao UPDAte:
        findViewById<Button>(R.id.btnPUT).setOnClickListener {// todos os id estao dentro do R
            updateUser() // mesmo nome do APIService para fazer associacao e nome do metodo a baixo
        }

        //acao do botao Delete:
        findViewById<Button>(R.id.btnDELETE).setOnClickListener {// todos os id estao dentro do R
            deleteUser() // mesmo nome do APIService para fazer associacao e nome do metodo a baixo
        }
    }


    //recupera dados de usuario
    private fun getUserByID() {
        lifecycleScope.launch {   // recurso para trabalhar com assincronismo, toda requisicao a uma api rest e assincrona
            //chamada para o endpoit
            val result = apiService.getUserByID("4")

            if (result.isSuccessful) {
                Log.e(
                    "Getting-Data",
                    "${result.body()?.data}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data
            } else {
                Log.e(
                    "Getting-Data",
                    "${result.message()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data

            }
        }
    }

    //inserir dados de usuario
    private fun createUser() {

        lifecycleScope.launch() {
            var body = JsonObject().apply {
                addProperty("name", "Guilherme")
                addProperty("job", "Compositor")
            }
            val result = apiService.createUser(body)

            if (result.isSuccessful) {
                Log.e(
                    "Create-Data",
                    "${result.body()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data
            } else {
                Log.e(
                    "Create-Data",
                    "${result.message()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data

            }
        }
    }

    private fun updateUser() {
        lifecycleScope.launch() {
            var body = JsonObject().apply {
                addProperty("name", "Gabriela")
                addProperty("job", "Compositora")
            }
            val result = apiService.updateUser("734", body)

            if (result.isSuccessful) {
                Log.e(
                    "Update-Data",
                    "${result.body()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data
            } else {
                Log.e(
                    "Update-Data",
                    "${result.message()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data

            }
        }
    }


    private fun deleteUser() {
        lifecycleScope.launch() {

            val result = apiService.deleteUser("2")

            if (result.isSuccessful) {
                Log.e(
                    "Delete-Data",
                    "${result}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data
            } else {
                Log.e(
                    "Delete-Data",
                    "${result.message()}"
                ) // aqui colocamos nome da tag e a saida chamando um cara chamado data

            }


        }
    }
}