package cl.jpvs.mod5ej17

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import cl.jpvs.mod5ej17.databinding.ActivityMainBinding
import coil.load

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val divisas = listOf<String>("Dolar","Pesos","Euro")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView.load("https://w7.pngwing.com/pngs/402/699/png-transparent-blue-and-gray-icon-loan-cryptocurrency-money-exchange-ethereum-painted-time-money-exchange-watercolor-painting-investment-payment.png")
        binding.spinnerMonedaOrigen.adapter = ArrayAdapter( this, android.R.layout.simple_spinner_item, divisas)
        binding.spinnerMonedaDestino.adapter = ArrayAdapter( this, android.R.layout.simple_spinner_item, divisas)
        initListener()
    }
    private fun initListener() {
        binding.btnConvert.setOnClickListener{
            val monto = binding.editTextNumberEntrada
        }


    }

}