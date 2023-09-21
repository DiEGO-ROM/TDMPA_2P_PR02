package com.example.tdmpa_2p_pr02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinuar = findViewById<Button>(R.id.btnContinuar)
        val spinCategoria = findViewById<Spinner>(R.id.spinCategoria)
        val spinProductos = findViewById<Spinner>(R.id.spinProductos)
        val imgProducto = findViewById<ImageView>(R.id.imgProducto)
        var txtDescripcion = findViewById<TextView>(R.id.txtDescripcion)

        val categorias = resources.getStringArray(R.array.Categorías)
        val adaptadorCategorias = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        spinCategoria.adapter = adaptadorCategorias

        val hamburguesas = resources.getStringArray(R.array.Hamburguesa)
        val adaptadorHamburguesas = ArrayAdapter(this, android.R.layout.simple_spinner_item, hamburguesas)

        val tacos = resources.getStringArray(R.array.Tacos)
        val adaptadorTacos = ArrayAdapter(this, android.R.layout.simple_spinner_item, tacos)

        val refrescos = resources.getStringArray(R.array.Refresco)
        val adaptadorRefrescos = ArrayAdapter(this, android.R.layout.simple_spinner_item, refrescos)


        var productos = hamburguesas
        var producto = "Hamburguesa Sencilla"

        spinCategoria.adapter = adaptadorCategorias

        spinCategoria.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?,
                                        position: Int,
                                        id: Long
            ) {
                var categoria = categorias[position]

                when (categoria) {
                    "Hamburguesa" -> {
                        spinProductos.adapter = adaptadorHamburguesas
                        productos = hamburguesas
                    }
                    "Tacos" -> {
                        spinProductos.adapter = adaptadorTacos
                        productos = tacos
                    }
                    "Refresco" -> {
                        spinProductos.adapter = adaptadorRefrescos
                        productos = refrescos
                    }
                }


                Toast.makeText(this@MainActivity, "Categoria: " + categoria, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Nada", Toast.LENGTH_SHORT).show()
            }
        }



        spinProductos.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?,
                                        position: Int,
                                        id: Long
            ) {
                producto = productos[position]

                when (producto) {
                    "Hamburguesa Sencilla" -> {
                        imgProducto.setImageResource(R.drawable.hamburguesaencilla)
                        txtDescripcion.text = "Hamburguesa Sencilla: Hamburguesa con una carne."
                    }
                    "Hamburguesa Doble" -> {
                        imgProducto.setImageResource(R.drawable.ham_doble)
                        txtDescripcion.text = "Hamburguesa Doble: Hamburguesa con dos carnes."
                    }
                    "Hamburguesa Vegetariana" -> {
                        imgProducto.setImageResource(R.drawable.hamburguesa_veg)
                        txtDescripcion.text = "Hamburguesa Vegetariana: Hamburguesa con verduras."
                    }
                    "Tacos al Pastor" -> {
                        imgProducto.setImageResource(R.drawable.t_pastor)
                        txtDescripcion.text = "Tacos al Pastor: Tacos con carne de cerdo preparada en un trompo."
                    }
                    "Tacos de Birria" -> {
                        imgProducto.setImageResource(R.drawable.t_birria)
                        txtDescripcion.text = "Tacos de Birria: Tacos con carne de carnero adobado con algunos tipos de chiles."
                    }
                    "Tacos de Cecina" -> {
                        imgProducto.setImageResource(R.drawable.t_cecina)
                        txtDescripcion.text = "Tacos de Cecina: Tacos con carne salada y secada al sol."
                    }
                    "Coca-Cola" -> {
                        imgProducto.setImageResource(R.drawable.coca)
                        txtDescripcion.text = "Coca-Cola: Refresco con cocaina."
                    }
                    "Sprite" -> {
                        imgProducto.setImageResource(R.drawable.sprite)
                        txtDescripcion.text = "Sprite: Refresco sabor lima-limon."
                    }
                    "Fanta" -> {
                        imgProducto.setImageResource(R.drawable.fanta)
                        txtDescripcion.text = "Fanta: Refresco sabor naranja."
                    }
                }

                Toast.makeText(this@MainActivity, "Producto: " + producto, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Nada", Toast.LENGTH_SHORT).show()
            }
        }

        btnContinuar.setOnClickListener{
            val intent = Intent(this@MainActivity, CotizarActivity::class.java)
            intent.putExtra("producto", producto) // esta cosa manda una variable al otro Activity
            startActivity(intent)
        }

    }
}