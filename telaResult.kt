package com.example.liviadantas.testekotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.telaresult.*


class telaResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.telaresult)
        //declarando os text views
        var txt1 = findViewById<TextView>(R.id.txt1)
        var txt2 = findViewById<TextView>(R.id.txt2)
        var txt3 = findViewById<TextView>(R.id.txt3)

        //gerando uma nova intent para buscar os resultados
        var intentResult = intent.getStringExtra("pessoa")

        //buscando a referência da intent
        val pessoa = Gson().fromJson(intentResult, Pessoa::class.java)
        txt1.text = pessoa.nome
        txt2.text = pessoa.idade.toString()
        txt3.text = pessoa.tel

    }
}