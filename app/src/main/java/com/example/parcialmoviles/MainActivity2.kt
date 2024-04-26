package com.example.parcialmoviles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.TranslateAnimation
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import android.view.View
import android.view.animation.Animation

import java.util.*




class MainActivity2 : AppCompatActivity() {
    data class Anuncio(val imagenResId: Int)
    val anuncios = listOf(
        Anuncio(R.drawable.anuncio1),

    )
    private lateinit var imageView5: ImageView
    private lateinit var imageView6: ImageView


    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)


        cambiarImagenAutomaticamente()
    }


    fun irAempezar(view: View) {
        val intent = Intent(this, EmpezarCompraActivity::class.java)
        startActivity(intent)
    }






        private fun cambiarImagenAutomaticamente() {
        val timer = Timer()
        val task = object : TimerTask() {
            override fun run() {
                runOnUiThread {

                    cambiarImagen()
                }
            }
        }


        timer.schedule(task, 0, 5000)
    }

    private fun cambiarImagen() {

        currentIndex = (currentIndex + 1) % anuncios.size


        val resourceId = anuncios[currentIndex].imagenResId


        imageView6.setImageResource(resourceId)


        val fadeOutAnimation = AlphaAnimation(1f, 0f)
        fadeOutAnimation.duration = 1000
        fadeOutAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                imageView5.visibility = View.INVISIBLE // Oculta imageView5 después de la animación de desaparición
            }
            override fun onAnimationRepeat(animation: Animation?) {}
        })
        imageView5.startAnimation(fadeOutAnimation)


        val fadeInAnimation = AlphaAnimation(0f, 1f)
        fadeInAnimation.duration = 1000
        fadeInAnimation.startOffset = 1000
        imageView6.visibility = View.VISIBLE
        imageView6.startAnimation(fadeInAnimation)


        fadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                imageView6.visibility = View.VISIBLE
                imageView5.visibility = View.INVISIBLE
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
    private fun carousel_init(view_carousel:ImageCarousel){
        val carrusel:ImageCarousel = view_carousel
        val list = mutableListOf<CarouselItem>()
        list.add(CarouselItem("url"))

        carusel.setData(list)

    }
}


