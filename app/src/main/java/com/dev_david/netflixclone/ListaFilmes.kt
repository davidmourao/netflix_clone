package com.dev_david.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.dev_david.netflixclone.Adapter.FilmesAdapter
import com.dev_david.netflixclone.Model.addFilmes
import com.dev_david.netflixclone.OnClick.OnItemClickListener
import com.dev_david.netflixclone.OnClick.addOnItemClickListener
import com.dev_david.netflixclone.databinding.ActivityFormCadastroBinding
import com.dev_david.netflixclone.databinding.ActivityListaFilmesBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFilmes : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerFilmes = binding.recyclerView
        recyclerFilmes.adapter = FilmesAdapter(addFilmes())
        recyclerFilmes.layoutManager = GridLayoutManager(applicationContext,3)

        recyclerFilmes.addOnItemClickListener(object : OnItemClickListener{
            override fun onItemClicked(position: Int, view: View) {

                when{
                    position == 0 -> DetalhesFilmes()
                }
            }
        })


    }

    private fun DetalhesFilmes(){
        val intent = Intent(this, DetalhesFilmes::class.java)
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.deslogar -> {
                FirebaseAuth.getInstance().signOut()
                voltarTelaLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun voltarTelaLogin(){
        val intent = Intent(this,FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}