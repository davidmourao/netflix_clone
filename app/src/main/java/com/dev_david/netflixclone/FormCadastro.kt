package com.dev_david.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dev_david.netflixclone.databinding.ActivityFormCadastroBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarCadastro
        toolbar.setBackgroundColor(getColor(R.color.white))

        binding.btCadastrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem_erro = binding.mensagemErro

            if(email.isEmpty() || senha.isEmpty()){
                mensagem_erro.setText("Preencha todos os campos")

            }else{

                CadastrarUsuario()

            }

        }

    }
    private fun CadastrarUsuario()
    {

        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem_erro = binding.mensagemErro
        
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha,)
            .addOnCompleteListener {
                if(it.isSuccessful)
                {
                   Toast.makeText(this,"Usuário Cadastrado",Toast.LENGTH_SHORT).show()
                    binding.editEmail.setText("")
                    binding.editSenha.setText("")
                    mensagem_erro.setText("")
                }

        }.addOnFailureListener {

                var erro = it

                when{

                    erro is FirebaseAuthWeakPasswordException ->
                        mensagem_erro.setText("Digite uma senha com no minimo 6 caracteres")
                    erro is FirebaseAuthUserCollisionException->
                        mensagem_erro.setText("Usuário ja cadastrado")
                    erro is FirebaseNetworkException ->
                        mensagem_erro.setText("Sem conexão de internet")
                    else -> mensagem_erro.setText("Usuário ja cadastrado")


                }

            mensagem_erro.setText("Erro ao cadastrar")
            }

    }
}