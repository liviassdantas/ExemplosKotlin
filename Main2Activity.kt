package com.example.liviadantas.testekotlin

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class Main2Activity : AppCompatActivity() {
    //declarando os botões
    var edt1: EditText? = null
    var edt2: EditText? = null
    var edt3: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buscando os ids dos edit text
        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        edt3 = findViewById(R.id.edt3)
        //externalizando o botão
        findViewById<Button>(R.id.btn1).setOnClickListener(Salvar())
    }
    //click do botão
    private fun Salvar() = View.OnClickListener {
            //instanciando um nova pessoa
            var pessoa = Pessoa()
            //pegando as informações de pessoa
            pessoa.nome = edt1?.text.toString()
            pessoa.idade = edt2?.text.toString().toInt()
            pessoa.tel = edt3?.text.toString()

            //iniciando a intent que vai exibir o resultado
            val intentExibir  = Intent(this@Main2Activity, telaResult::class.java)

            //gerando o arquivo Gson para fazer a transferência de dados (serializable)
            val retorno = Gson().toJson(pessoa)

            //gerandoa chave para exibir a intent
            intentExibir.putExtra("pessoa", retorno)
            startActivity(intentExibir)



    }

}
