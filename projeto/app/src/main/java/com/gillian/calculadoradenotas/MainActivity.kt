package com.gillian.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.gillian.calculadoradenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val num1 = binding.nota1
        val num2 = binding.nota2
        val num3 = binding.nota3
        val num4 = binding.nota4
        val nfaltas = binding.faltas
        val resultado = binding.txtResultado

        binding.btCalcular.setOnClickListener{
           /* val num1 = binding.nota1
            val num2 = binding.nota2
            val num3 = binding.nota3
            val num4 = binding.nota4
            val nfaltas = binding.faltas
            val resultado = binding.txtResultado*/

            val nota1 = Integer.parseInt(num1.text.toString())
            val nota2 = Integer.parseInt(num2.text.toString())
            val nota3 = Integer.parseInt(num3.text.toString())
            val nota4 = Integer.parseInt(num4.text.toString())
            val numeroFaltas = Integer.parseInt(nfaltas.text.toString())

            val media = (nota1 + nota2 + nota3 + nota4) / 4

            if(media >= 5 && numeroFaltas <= 20){
                resultado.setText("Aluno aprovado! \n Média final: $media")
                resultado.setTextColor(getColor(R.color.verde))
            }else if(numeroFaltas > 20){
                resultado.setText("O aluno foi reprovado por faltas. \n Média final: $media")
                resultado.setTextColor(getColor(R.color.vermelho))
            }else if(media < 5){
                resultado.setText("O aluno foi reprovado por nota. \n Média final: $media")
                resultado.setTextColor(getColor(R.color.vermelho))
            }
        }
        binding.btLimpar.setOnClickListener{
            num1.setText("")
            num2.setText("")
            num3.setText("")
            num4.setText("")
            nfaltas.setText("")
            resultado.setText("")
        }
    }
}