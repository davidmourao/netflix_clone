package com.dev_david.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dev_david.netflixclone.databinding.ActivityFormLoginBinding
import com.dev_david.netflixclone.databinding.ActivityMainBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        verificarUsuarioLogado()

        binding.txtTelaCadastro.setOnClickListener {

            val intent = Intent(this,FormCadastro::class.java)
            startActivity(intent)


        }

        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagemErro = binding.mensagemErro

            if (email.isEmpty()||senha.isEmpty()){
                mensagemErro.setText("Preencha todos os campos")

            }else{
                AutenticarUsuario()
            }
        }
    }

    private fun AutenticarUsuario() {
        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagemErro = binding.mensagemErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {

            if (it.isSuccessful){
                Toast.makeText(this, "Login efetuado com sucesso",Toast.LENGTH_SHORT).show()
                IrParaTelaFilmes()
            }
        }.addOnFailureListener {

            var erro = it

            when{
                erro is FirebaseAuthInvalidCredentialsException ->
                    mensagemErro.setText("Email ou senha incorretos")
                erro is FirebaseNetworkException ->
                    mensagemErro.setText("Sem conexão")
                else -> mensagemErro.setText("Erro ao logar o usuário")
            }

            mensagemErro.setText("Erro ao logar")
        }
    }

    private fun verificarUsuarioLogado()
    {
        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null){
            IrParaTelaFilmes()
        }
    }

    private fun IrParaTelaFilmes() {
        val intent = Intent(this,ListaFilmes::class.java)
        startActivity(intent)
    }
}