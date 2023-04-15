package com.dev_david.netflixclone.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dev_david.netflixclone.ListaFilmes
import com.dev_david.netflixclone.Model.Filmes
import com.dev_david.netflixclone.databinding.ListaFilmesBinding

class FilmesAdapter(val filmes: MutableList<Filmes>):RecyclerView.Adapter<FilmesAdapter.FilmesViewHolder>(){

    inner class FilmesViewHolder(val binding: ListaFilmesBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val binding = ListaFilmesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FilmesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        with(holder){
            with(filmes[position]){
                binding.capaFilme.setImageResource(capaFilme)
            }
        }
    }

    override fun getItemCount() = filmes.size

}