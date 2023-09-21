package com.example.tdmpa_2p_pr02

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class CotizarActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotizar)

        var producto = intent?.extras?.getString("producto").toString()
        val txtProducto = findViewById<TextView>(R.id.txtProducto)
        txtProducto.text = producto

        var precio = 100
        var imgCotizar = findViewById<ImageView>(R.id.imgCotizar)
        val btnCotizar = findViewById<Button>(R.id.btnCotizar)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val numCotizar = findViewById<TextView>(R.id.numCotizar)


        when (producto) {
            "Hamburguesa Sencilla" -> {
                imgCotizar.setImageResource(R.drawable.hamburguesaencilla)
                precio = 100
            }
            "Hamburguesa Doble" -> {
                imgCotizar.setImageResource(R.drawable.ham_doble)
                precio = 120
            }
            "Hamburguesa Vegetariana" -> {
                imgCotizar.setImageResource(R.drawable.hamburguesa_veg)
                precio = 140
            }
            "Tacos al Pastor" -> {
                imgCotizar.setImageResource(R.drawable.t_pastor)
                precio = 50
            }
            "Tacos de Birria" -> {
                imgCotizar.setImageResource(R.drawable.t_birria)
                precio = 40
            }
            "Tacos de Cecina" -> {
                imgCotizar.setImageResource(R.drawable.t_cecina)
                precio = 30
            }
            "Coca-Cola" -> {
                imgCotizar.setImageResource(R.drawable.coca)
                precio = 20
            }
            "Sprite" -> {
                imgCotizar.setImageResource(R.drawable.sprite)
                precio = 20
            }
            "Fanta" -> {
                imgCotizar.setImageResource(R.drawable.fanta)
                precio = 20
            }
        }

        btnCotizar.setOnClickListener{
            var numProductos = 1
            if(numCotizar.text.isNotEmpty())
                numProductos = numCotizar.text.toString().toInt()

            var total = precio * numProductos
            txtTotal.text = "Total: " + total.toString()
        }

    }
}