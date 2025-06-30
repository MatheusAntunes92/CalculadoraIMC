package com.comunidadedevspace.imc

import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()

        val classificacao: String
        val cor: Int

        if (result < 18.5f) {
            classificacao = "MAGREZA"
            cor = ContextCompat.getColor(this, R.color.vermelho)

        } else if (result in 18.5f..24.9f) {
            classificacao = "NORMAL"
            cor = ContextCompat.getColor(this, R.color.verde)

        } else if (result in 25f..29.9f) {
            classificacao = "SOBREPESO"
            cor = ContextCompat.getColor(this, R.color.amarelo)

        } else if (result in 30f..39.9f) {
            classificacao = "OBESIDADE"
            cor = ContextCompat.getColor(this, R.color.vermelho)

        } else {
            classificacao = "OBESIDADE GRAVE"
            cor = ContextCompat.getColor(this, R.color.vermelho)
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(cor)

    }
}