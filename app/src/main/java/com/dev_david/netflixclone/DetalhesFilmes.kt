package com.dev_david.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.dev_david.netflixclone.Adapter.FilmesAdapter
import com.dev_david.netflixclone.Model.addFilmes
import com.dev_david.netflixclone.databinding.ActivityDetalhesFilmesBinding
import com.squareup.picasso.Picasso

class DetalhesFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        val recyclerOutrosFilmes = binding.recyclerOutrosFilmes
        recyclerOutrosFilmes.adapter = FilmesAdapter(addFilmes())
        recyclerOutrosFilmes.layoutManager = GridLayoutManager(applicationContext,3)

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflix-clone-9209e.appspot.com/o/video.jpg?alt=media&token=ec45114d-ef18-40e4-bd55-e91b31d6b538"
        Picasso.get().load(capaTheWitcher).fit().into(binding.capa)

        binding.playVideo.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun Toolbar (){
        val toolbarDetalhes = binding.toolbarDetalhes
        toolbarDetalhes.setNavigationIcon(getDrawable(R.drawable.ic_arrow_back_24   ))
        toolbarDetalhes.setNavigationOnClickListener {
            val intent = Intent(this,ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }
    }
}