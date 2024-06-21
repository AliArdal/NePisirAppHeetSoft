package com.example.casestudy.tanitim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.casestudy.MainActivity
import com.example.casestudy.R
import com.example.casestudy.databinding.ActivityUyeOlBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class UyeOlActivity : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding : ActivityUyeOlBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUyeOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.googleGir.setOnClickListener { signInWithGoogle() }

        firebaseAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.geri.setOnClickListener {
            val intent = Intent(this, Tanitim5Activity::class.java)
            startActivity(intent)
        }

        val passwordEditText = binding.sifre

        val showHideButton = binding.btnShowHidePassword
        showHideButton.setOnClickListener {
            if(passwordEditText.inputType == InputType.TYPE_TEXT_VARIATION_PASSWORD){
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHideButton.setImageResource(R.drawable.baseline_visibility_24)
            } else {
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                showHideButton.setImageResource(R.drawable.baseline_visibility_24)
            }
            passwordEditText.setSelection(passwordEditText.text.length)
        }

        binding.uyeOl.setOnClickListener {
            val email = binding.ePosta.text.toString()
            val sifre = binding.sifre.text.toString()


            if(sifre.isNotEmpty() && email.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, sifre)
                    .addOnCompleteListener(this) { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Kayıt Başarılı" , Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, GirisActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this,"Kayıt Başarısız" , Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this,"E-Posta ve Şifrenizi Giriniz" , Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInWithGoogle(){
        val signInIntent = googleSignInClient.signInIntent
        launcher.launch(signInIntent)
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            handleResults(task)
        }
    }

    private fun handleResults(task : Task<GoogleSignInAccount>){
        if(task.isSuccessful) {
            val account: GoogleSignInAccount? = task.result
            if(account != null){
                updateUI(account)
            }
        } else {
            showToast("Sign in Failed , Try Again later")
        }
    }

    private fun updateUI(account: GoogleSignInAccount){
        val credential = GoogleAuthProvider.getCredential(account.idToken,null)
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // Handle sign-in failure
                showToast("Firebase Auth Failed")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
