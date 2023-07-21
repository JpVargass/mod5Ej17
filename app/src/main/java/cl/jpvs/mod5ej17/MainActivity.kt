package cl.jpvs.mod5ej17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import cl.jpvs.mod5ej17.databinding.ActivityMainBinding

//import coil.load

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("USD", "CLP", "EUR")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.imageView.load("https://w7.pngwing.com/pngs/402/699/png-transparent-blue-and-gray-icon-loan-cryptocurrency-money-exchange-ethereum-painted-time-money-exchange-watercolor-painting-investment-payment.png")
        binding.spinnerMonedaOrigen.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        binding.spinnerMonedaDestino.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, divisas)
        initListener()
    }


    private fun initListener() {
        binding.btnConvert.setOnClickListener {
            val monto = binding.editTextNumberEntrada.text.toString().toInt()
            val divisaActual = binding.spinnerMonedaOrigen.selectedItem.toString()
            val divisaCambio = binding.spinnerMonedaDestino.selectedItem.toString()

            val resultado =
                conversorDivisas(monto.toDouble(), divisaActual, divisaCambio).toString()
            binding.textViewResultado.text = resultado
        }
        binding.btnReset.setOnClickListener(View.OnClickListener {
            limpiar()
        })
        binding
    }

    private fun conversorDivisas(monto: Double, divisaActual: String, divisaCambio: String): Any {
        var resultado = monto
        when (divisaActual) {
            "USD" -> if (divisaCambio == "CLP") {
                resultado = monto * 817; } else if (divisaCambio == "USD") {

                resultado = monto * 1
            } else {
                resultado = monto * 0.89
            }

            "CLP" -> if (divisaCambio == "CLP") {
                resultado = monto * 1
            } else if (divisaCambio == "USD") {
                resultado = monto * 0.001
            } else {
                resultado = monto * 0.001
            }

            "EUR" -> if (divisaCambio == "CLP") {
                resultado = monto * 910
            } else if (divisaCambio == "USD") {
                resultado = monto * 1.11
            } else if (divisaCambio == "EUR") {
                resultado = monto * 1
            }


        }
        return resultado
    }

    fun limpiar() {
        binding.textViewResultado.text = ""
        binding.editTextNumberEntrada.setText("")

    }
}
